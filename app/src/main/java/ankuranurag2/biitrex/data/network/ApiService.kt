package ankuranurag2.biitrex.data.network

import ankuranurag2.biitrex.models.CurrencyResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 * created by ankur on 11/3/20
 */
public interface ApiService {
    @GET("getcurrencies")
    suspend fun getCurrencyData(): Response<CurrencyResponse>
}