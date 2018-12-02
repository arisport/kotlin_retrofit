package com.example.arispanayiotou.kotlin.models.network

/**
 * Created by arispanayiotou on 02/12/2018
 */
abstract class AbstractResponseObject {

    enum class ErrorType {
        NONE, NETWORK_ERROR, SERVER_ERROR
    }

    var networkError: Throwable? = null
    var serverErrorModel: ServerErrorModel? = null
    var errorType: ErrorType = ErrorType.NONE

}