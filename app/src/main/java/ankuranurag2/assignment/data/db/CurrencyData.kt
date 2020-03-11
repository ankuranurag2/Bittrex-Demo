package ankuranurag2.assignment.data.db

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

/**
 * Other fields have been ignored from the API response, as they are not being used anywhere
 */
@Entity(tableName = "currency_data")
data class CurrencyData(
    @SerializedName("Currency")
    val currency: String?,
    @SerializedName("CurrencyLong")
    val currencyLong: String?,
    @SerializedName("TxFee")
    val txFee: Double?
)