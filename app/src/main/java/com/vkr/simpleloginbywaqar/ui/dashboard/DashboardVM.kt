package com.vkr.simpleloginbywaqar.ui.dashboard

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vkr.simpleloginbywaqar.data.Data
import com.vkr.simpleloginbywaqar.network.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardVM @Inject constructor(
    private val repository: DashBoardRepo
) : ViewModel() {
    var dashboardData = mutableStateOf(Data())
        private set

    private val _mockDataResponse: MutableLiveData<Resource<Data>> =
        MutableLiveData()
    val mockDataResponse: LiveData<Resource<Data>>
        get() = _mockDataResponse

    fun hitMockApi() = viewModelScope.launch {
        _mockDataResponse.value = repository.hitMockApi()
    }
}