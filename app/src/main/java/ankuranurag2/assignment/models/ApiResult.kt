package ankuranurag2.assignment.models

/**
 * created by ankur on 11/3/20
 */
data class ApiResult<out T>(
    val status: Status,
    val data: T?,
    val msg: String?
) {
    companion object {
        fun <T> success(data: T?): ApiResult<T> {
            return ApiResult(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T? = null): ApiResult<T> {
            return ApiResult(Status.ERROR, data, msg)
        }
    }
}

enum class Status {
    SUCCESS,
    ERROR
}