package ankuranurag2.assignment.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * created by ankur on 11/3/20
 */
@Dao
interface CurrencyDao {

    //won't use live data here
    @Query("SELECT * from currency_data")
    suspend fun getCurrencyData(): List<CurrencyData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(currencyList: List<CurrencyData>)
}