package com.vkr.simpleloginbywaqar.ui.screens.dashboard

import androidx.compose.runtime.mutableStateOf
import com.vkr.simpleloginbywaqar.ui.data.Data

class DashboardVM {
    var dashboardData = mutableStateOf(Data())
        private set
}