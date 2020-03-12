package ankuranurag2.assignment.di

import ankuranurag2.assignment.data.network.ApiService
import ankuranurag2.assignment.utils.BASE_URL
import ankuranurag2.assignment.utils.DEFAULT_TIME_OUT
import ankuranurag2.assignment.utils.isUAT
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * created by ankur on 11/3/20
 */
val networkModule = module {
    factory { getLoggingInterceptor() }
    factory { getOkHttpClient(get()) }
    factory { getApiService(get()) }

    single { getRetrofit(get()) }
}

fun getOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
    val builder = OkHttpClient().newBuilder()

    if (isUAT())
        builder.addInterceptor(interceptor)

    return builder.connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
        .readTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
        .writeTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
        .build()
}

fun getLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}


fun getRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
    .client(okHttpClient)
    .build()


fun getApiService(retrofit: Retrofit): ApiService =
    retrofit.create(ApiService::class.java)