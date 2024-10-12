package com.vkr.simpleloginbywaqar.ui.dashboard

import com.vkr.simpleloginbywaqar.network.ApiService
import com.vkr.simpleloginbywaqar.network.SafeApiCall
import javax.inject.Inject

class DashBoardRepo @Inject constructor(
    private val apiService: ApiService
) : SafeApiCall {

    suspend fun hitMockApi() = safeApiCall {
        apiService.getDataFromMockApi()
    }
}