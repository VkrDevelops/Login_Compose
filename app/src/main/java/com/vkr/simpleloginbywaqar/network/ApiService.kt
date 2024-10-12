package com.vkr.simpleloginbywaqar.network

import com.vkr.simpleloginbywaqar.data.Data
import com.vkr.simpleloginbywaqar.ui.utils.Constants.GET_DATA
import retrofit2.http.POST

interface ApiService {
    @POST(GET_DATA)
    suspend fun getDataFromMockApi(): Data
}
