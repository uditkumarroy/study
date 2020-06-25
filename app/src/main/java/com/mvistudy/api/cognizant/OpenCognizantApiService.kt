package com.mvistudy.api.cognizant

import androidx.lifecycle.LiveData
import com.mvistudy.api.cognizant.network_response.Dropboxusercontent
import com.mvistudy.utils.GenericApiResponse
import retrofit2.http.GET

interface OpenCognizantApiService {

    @GET("s/2iodh4vg0eortkl/facts.json")
    fun getPostData(): LiveData<GenericApiResponse<Dropboxusercontent>>

}