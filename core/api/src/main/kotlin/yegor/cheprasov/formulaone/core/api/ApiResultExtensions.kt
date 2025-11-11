package yegor.cheprasov.formulaone.core.api

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.InterruptedIOException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

suspend fun <T> runApiRequest(block: suspend () -> T): ApiResult<T> = withContext(Dispatchers.IO) {
    try {
        ApiResult.Success(block())
    } catch (t: Throwable) {
        t.toApiResult()
    }
}

internal fun Throwable.toApiResult(): ApiResult<Nothing> = when (this) {
    is HttpException -> ApiResult.HttpError(
        code = code(),
        message = message(),
        errorBody = response()?.errorBody()?.string(),
        cause = this
    )

    is UnknownHostException,
    is ConnectException -> ApiResult.NetworkError.Connection(this)

    is SocketTimeoutException,
    is InterruptedIOException -> ApiResult.NetworkError.Timeout(this)

    else -> ApiResult.UnknownError(this)
}

inline fun <T, R> ApiResult<T>.map(transform: (T) -> R): ApiResult<R> = when (this) {
    is ApiResult.Success -> ApiResult.Success(transform(data))
    is ApiResult.HttpError -> this
    is ApiResult.NetworkError -> this
    is ApiResult.UnknownError -> this
}

fun <T> ApiResult<T>.toKotlinResult(): Result<T> = when (this) {
    is ApiResult.Success -> Result.success(data)

    is ApiResult.HttpError -> Result.failure(
        ApiException.HttpError(code, message, errorBody, cause)
    )

    is ApiResult.NetworkError.Connection -> Result.failure(ApiException.Connection(throwable))
    is ApiResult.NetworkError.Timeout -> Result.failure(ApiException.Timeout(throwable))
    is ApiResult.NetworkError.Unknown -> Result.failure(ApiException.NetworkUnknown(throwable))
    is ApiResult.UnknownError -> Result.failure(ApiException.Unknown(throwable))
}