package com.example.redditnews.core.presentation

import com.example.redditnews.R
import com.example.redditnews.core.domain.DataError

fun DataError.toUiText(): UiText.StringResourceId {
    val resourceId = when(this){
        DataError.Local.DISK_FULL -> R.string.data_error_local_disk_full
        DataError.Local.UNKNOWN -> R.string.data_error_local_unknown
        DataError.Remote.REQUEST_TIMEOUT ->R.string.data_error_remote_too_many_requests
        DataError.Remote.TOO_MANY_REQUESTS -> R.string.data_error_remote_too_many_requests
        DataError.Remote.NO_INTERNET -> R.string.data_error_remote_no_internet
        DataError.Remote.SERVER -> R.string.data_error_remote_server_error
        DataError.Remote.SERIALIZATION -> R.string.data_error_remote_serialization_error
        DataError.Remote.UNKNOWN -> R.string.data_error_remote_unknown_error
    }
    return UiText.StringResourceId(resourceId)
}