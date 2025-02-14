package ankuranurag2.biitrex.di

import ankuranurag2.biitrex.data.db.CurrencyDao
import ankuranurag2.biitrex.data.network.ApiService
import ankuranurag2.biitrex.repository.CurrencyRepository
import ankuranurag2.biitrex.viewmodels.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * created by ankur on 11/3/20
 */
val mainActivityModule = module {
    single { getCurrencyRepo(get(), get()) }

    viewModel { MainViewModel(androidApplication(), get()) }
}

fun getCurrencyRepo(currencyDao: CurrencyDao, apiService: ApiService) =
    CurrencyRepository(apiService, currencyDao)