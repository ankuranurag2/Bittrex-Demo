package ankuranurag2.assignment.data.network

import ankuranurag2.assignment.models.CurrencyResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 * created by ankur on 11/3/20
 */
public interface ApiService {
    @GET("getcurrencies")
    suspend fun getCurrencyData(): Response<CurrencyResponse>
}