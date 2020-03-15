package ankuranurag2.assignment.repository

import android.content.Context
import ankuranurag2.assignment.data.db.CurrencyDao
import ankuranurag2.assignment.data.db.CurrencyData
import ankuranurag2.assignment.data.network.ApiService
import ankuranurag2.assignment.models.ApiResult
import ankuranurag2.assignment.utils.AppUtils
import ankuranurag2.assignment.utils.checkForInternet

/**
 * created by ankur on 11/3/20
 */
class CurrencyRepository(private val apiService: ApiService, private val dao: CurrencyDao) {

    suspend fun getCurrencyData(context: Context): ApiResult<List<CurrencyData>> {
        var currencyList: List<CurrencyData>? = null

        if (context.checkForInternet()) {
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

        AppUtils.sendNewDataBroadcast(context)

        return if (currencyList.isNullOrEmpty())
            ApiResult.error("No data found!")
        else
            ApiResult.success(currencyList)
    }
}