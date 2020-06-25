package com.mvistudy.repository.cognizant

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.switchMap
import com.mvistudy.api.cognizant.OpenCognizantApiService
import com.mvistudy.api.cognizant.network_response.Dropboxusercontent
import com.mvistudy.api.cognizant.network_response.Rows
import com.mvistudy.models.CognizantPost
import com.mvistudy.persistence.CognizantDao
import com.mvistudy.repository.JobManager
import com.mvistudy.repository.NetworkBoundResource
import com.mvistudy.session.SessionManager
import com.mvistudy.ui.DataState
import com.mvistudy.ui.cognizant.state.CognizantViewState
import com.mvistudy.utils.ApiSuccessResponse
import com.mvistudy.utils.GenericApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CognizantRepository
@Inject
constructor(
    val openCognizantApiService: OpenCognizantApiService,
    val sessionManager: SessionManager,
    val cognizantDao: CognizantDao
) : JobManager("CognizantRepository") {
    private val TAG = "App debug"

    fun getSearchPost(): LiveData<DataState<CognizantViewState>> {
        return object :
            NetworkBoundResource<Dropboxusercontent, List<CognizantPost>, CognizantViewState>(
                sessionManager.isConnectedToTheInternet(), true, false, true
            ) {
            override suspend fun createCacheRequestAndReturn() {
                withContext(Dispatchers.Main) {

                    // finishing by viewing db cache
                    result.addSource(loadFromCache()) { viewState ->
                        onCompleteJob(DataState.data(viewState, null))
                    }
                }
            }

            override suspend fun handleApiSuccessResponse(response: ApiSuccessResponse<Dropboxusercontent>) {
                Log.e(TAG, "response ${response}")
                val cogziPostList: ArrayList<CognizantPost> = ArrayList()
                val dataRows: List<Rows> = response.body.rows
                for (cognizantResponse in dataRows) {
                    Log.e(TAG, "response ${cognizantResponse}")
                    cogziPostList.add(
                        CognizantPost(
                            pk = 1,
                            title = "${cognizantResponse.title}",
                            description = "${cognizantResponse.description}",
                            imageHref = "${cognizantResponse.imageHref}"
                        )
                    )
                }
                updateLocalDb(cogziPostList)

                createCacheRequestAndReturn()
            }

            override fun createCall(): LiveData<GenericApiResponse<Dropboxusercontent>> {
                return openCognizantApiService.getPostData()
            }

            override fun loadFromCache(): LiveData<CognizantViewState> {
                return cognizantDao.getAllPosts()
                    .switchMap {
                        object : LiveData<CognizantViewState>() {
                            override fun onActive() {
                                super.onActive()
                                value = CognizantViewState(
                                    CognizantViewState.CognizantFields(
                                        cognizantPostList = it
                                    )
                                )
                            }
                        }
                    }
            }

            override suspend fun updateLocalDb(cacheObject: List<CognizantPost>?) {
                if (cacheObject != null) {
                    withContext(IO) {
                        for (cognizantPost in cacheObject) {
                            try {
                                launch {
                                    Log.d(TAG, "updateLocalDb: inserting blog: ${cognizantPost}")
                                    cognizantDao.insert(cognizantPost)
                                }
                            } catch (e: Exception) {
                                Log.e(
                                    TAG,
                                    "updateLocalDb: error updating cache data on blog post with slug: ${cognizantPost.title}. " +
                                            "${e.message}"
                                )
                            }
                        }
                    }
                }
            }

            override fun setJob(job: Job) {
                addJob("getSearchPost", job)
            }

        }.asLiveData()
    }
}