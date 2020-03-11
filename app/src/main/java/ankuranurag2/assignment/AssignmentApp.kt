package ankuranurag2.assignment

import android.app.Application
import ankuranurag2.assignment.di.databaseModule
import ankuranurag2.assignment.di.mainActivityModule
import ankuranurag2.assignment.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * created by ankur on 11/3/20
 */
class AssignmentApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@AssignmentApp)
            modules(listOf(mainActivityModule, networkModule, databaseModule))
        }
    }
}