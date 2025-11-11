package yegor.cheprasov.formulaone.core.api

sealed class ApiResult<out T> {
    data class Success<T>(val data: T) : ApiResult<T>()

    data class HttpError(
        val code: Int,
        val message: String? = null,
        val errorBody: String? = null,
        val cause: Throwable? = null
    ) : ApiResult<Nothing>()

    sealed class NetworkError(open val throwable: Throwable) : ApiResult<Nothing>() {
        data class Connection(override val throwable: Throwable) : NetworkError(throwable)
        data class Timeout(override val throwable: Throwable) : NetworkError(throwable)
        data class Unknown(override val throwable: Throwable) : NetworkError(throwable)
    }

    data class UnknownError(val throwable: Throwable) : ApiResult<Nothing>()
}