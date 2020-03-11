package ankuranurag2.assignment.repository

import ankuranurag2.assignment.data.network.ApiService

/**
 * created by ankur on 11/3/20
 */
public class CurrencyRepository(private val apiService: ApiService) {

    suspend fun getCurrencyData() = apiService.getCurrencyData()
}