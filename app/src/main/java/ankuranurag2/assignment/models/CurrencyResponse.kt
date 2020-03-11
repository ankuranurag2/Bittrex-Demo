package ankuranurag2.assignment.models

import ankuranurag2.assignment.data.db.CurrencyData
import com.google.gson.annotations.SerializedName


/**
 * created by ankur on 11/3/20
 */
data class CurrencyResponse(
    @SerializedName("message")
    val message: String?,
    @SerializedName("result")
    val result: List<CurrencyData>?,
    @SerializedName("success")
    val success: Boolean?
)