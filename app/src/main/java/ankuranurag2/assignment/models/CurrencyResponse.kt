package ankuranurag2.assignment.models

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

data class CurrencyData(
    @SerializedName("BaseAddress")
    val baseAddress: String?,
    @SerializedName("CoinType")
    val coinType: String?,
    @SerializedName("Currency")
    val currency: String?,
    @SerializedName("CurrencyLong")
    val currencyLong: String?,
    @SerializedName("IsActive")
    val isActive: Boolean?,
    @SerializedName("IsRestricted")
    val isRestricted: Boolean?,
    @SerializedName("MinConfirmation")
    val minConfirmation: Int?,
    @SerializedName("Notice")
    val notice: String?,
    @SerializedName("TxFee")
    val txFee: Double?
)