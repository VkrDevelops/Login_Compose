package com.vkr.simpleloginbywaqar.network

import android.accounts.NetworkErrorException
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.apache.http.conn.ConnectTimeoutException
import retrofit2.HttpException

interface SafeApiCall {
    suspend fun <T> safeApiCall(apiCall: suspend () -> T): Resource<T> {
        return withContext(Dispatchers.IO) {
            try {
                Resource.Success(apiCall.invoke())
            } catch (throwable: Throwable) {
                Log.e("SafeApiCall", "safeApiCall: ${throwable.message}")
                when (throwable) {
                    is HttpException -> {
                        Resource.Failure(
                            false,
                            throwable.code(),
                            throwable.response()?.errorBody()?.charStream().toString(),
                            null
                        )
                    }
                    is NetworkErrorException -> {
                        Resource.Failure(true, null, null)
                    }
                    is ConnectTimeoutException -> {
                        Resource.Failure(true, 100, null, "TimeOut Exception Manual")
                    }
                    else -> {
                        Resource.Failure(false, throwable.hashCode(), null, throwable.message)
                    }
                }
            }
        }
    }
}