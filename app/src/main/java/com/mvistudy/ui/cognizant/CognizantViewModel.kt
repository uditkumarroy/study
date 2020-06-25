package com.mvistudy.ui.cognizant


import androidx.lifecycle.LiveData
import com.mvistudy.models.CognizantPost
import com.mvistudy.repository.cognizant.CognizantRepository
import com.mvistudy.ui.BaseViewModel
import com.mvistudy.ui.DataState
import com.mvistudy.ui.cognizant.state.CognizantStateEvent
import com.mvistudy.ui.cognizant.state.CognizantStateEvent.CognizantSearchEvent
import com.mvistudy.ui.cognizant.state.CognizantStateEvent.None
import com.mvistudy.ui.cognizant.state.CognizantViewState
import com.mvistudy.utils.AbsentLiveData
import javax.inject.Inject

class CognizantViewModel @Inject constructor(
    private val cognizantRepository: CognizantRepository
) : BaseViewModel<CognizantStateEvent, CognizantViewState>() {
    override fun handleStateEvent(stateEvent: CognizantStateEvent): LiveData<DataState<CognizantViewState>> {
        when (stateEvent) {
            is CognizantSearchEvent -> {
                return let {
                    cognizantRepository.getSearchPost()
                }
            }
            is None -> {
                return AbsentLiveData.create()
            }
        }
    }

    override fun initNewViewState(): CognizantViewState {
        return CognizantViewState()
    }

    fun setQuery(query: String) {
        val update = getCurrentViewStateOrNew()
        update.cognizantFelds.searchQuery = query
        _viewState.value = update
    }

    fun setCognizantPostList(cognizantPostList: List<CognizantPost>) {
        val update = getCurrentViewStateOrNew()
        update.cognizantFelds.cognizantPostList = cognizantPostList
        _viewState.value = update
    }

    fun cancelActiveJobs() {
        cognizantRepository.cancelActiveJobs() // cancel active jobs
        handlePendingData() // hide progress bar
    }

    fun handlePendingData() {
        setStateEvent(None())
    }

    override fun onCleared() {
        super.onCleared()
        cancelActiveJobs()
    }
}