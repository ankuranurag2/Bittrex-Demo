package ankuranurag2.assignment.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Other fields have been ignored from the API response, as they are not being used anywhere
 */

/**
 * Currency has been made primary, so when new data arrives, previous gets replaced.
 * See, the conflictStrategy in {CurrencyDao.insertAll()}
 */
@Entity(tableName = "currency_data")
data class CurrencyData(
    @PrimaryKey
    @SerializedName("Currency")
    val currency: String?,
    @SerializedName("CurrencyLong")
    val currencyLong: String?,
    @SerializedName("TxFee")
    val txFee: Double?
)