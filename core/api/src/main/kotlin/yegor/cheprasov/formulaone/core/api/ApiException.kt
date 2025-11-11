package yegor.cheprasov.formulaone.core.api

sealed class ApiException(message: String?, cause: Throwable?) : Exception(message, cause) {

    class HttpError(
        val code: Int,
        val serverMessage: String?,
        val errorBody: String?,
        cause: Throwable?
    ) : ApiException("HTTP $code: $serverMessage", cause)

    class Connection(cause: Throwable) : ApiException("No internet connection", cause)
    class Timeout(cause: Throwable) : ApiException("Request timed out", cause)
    class NetworkUnknown(cause: Throwable) : ApiException("Unknown network error", cause)
    class Unknown(cause: Throwable) : ApiException(cause.message, cause)
}