package com.vkr.simpleloginbywaqar.network

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vkr.simpleloginbywaqar.ui.dashboard.DashBoardRepo
import com.vkr.simpleloginbywaqar.ui.dashboard.DashboardVM

class VmFactory(private val repository: DashBoardRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DashboardVM::class.java)) {
            return DashboardVM(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}