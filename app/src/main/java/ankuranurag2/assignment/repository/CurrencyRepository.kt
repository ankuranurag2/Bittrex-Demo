package ankuranurag2.assignment.repository

import ankuranurag2.assignment.data.db.CurrencyDao
import ankuranurag2.assignment.data.db.CurrencyData
import ankuranurag2.assignment.data.network.ApiService
import ankuranurag2.assignment.models.ApiResult
import java.lang.Exception

/**
 * created by ankur on 11/3/20
 */
public class CurrencyRepository(private val apiService: ApiService, private val dao: CurrencyDao) {

    suspend fun getCurrencyData(isConnected: Boolean): ApiResult<List<CurrencyData>> {
        var currencyList: List<CurrencyData>? = null

        if (isConnected) {
            try {
                val response = apiService.getCurrencyData()
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (true == responseBody?.success)
                        currencyList = responseBody.result
                }
            } catch (e: Exception) {
            }

            if (currencyList.isNullOrEmpty())
                currencyList = dao.getCurrencyData()
            else
                dao.insertAll(currencyList)
        } else {
            currencyList = dao.getCurrencyData()
        }

        return if (currencyList.isNullOrEmpty())
            ApiResult.error("No data found!")
        else
            ApiResult.success(currencyList)
    }
}