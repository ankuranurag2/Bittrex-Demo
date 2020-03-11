package ankuranurag2.assignment.di

import android.content.Context
import ankuranurag2.assignment.data.db.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * created by ankur on 11/3/20
 */
val databaseModule = module {
    single { getDatabase(androidApplication()) }
    factory { getCurrencyDao(get()) }
}

fun getDatabase(context: Context) = AppDatabase.getInstance(context)

fun getCurrencyDao(database: AppDatabase) = database.getCurrencyDao()