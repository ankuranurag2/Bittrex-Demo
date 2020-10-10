package ankuranurag2.biitrex.widget

import android.app.Service
import android.content.Intent
import android.os.IBinder
import ankuranurag2.biitrex.data.db.CurrencyDao
import ankuranurag2.biitrex.data.db.CurrencyData
import ankuranurag2.biitrex.utils.decrease
import ankuranurag2.biitrex.utils.increase
import kotlinx.coroutines.runBlocking
import org.koin.android.ext.android.inject

/**
 * created by ankur on 15/3/20
 */
class CurrencyService : Service() {

    private lateinit var currencyList: List<CurrencyData>
    private val currencyDao: CurrencyDao by inject()
    private var position = 0

    override fun onCreate() {
        fetchData()
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (currencyList.isNullOrEmpty())
            fetchData()

        if (currencyList.isNotEmpty()) {
            val action = intent?.action
            if (CurrencyWidgetProvider.NEXT_ACTION == action && position < currencyList.size)
                position = position.increase()
            else if (CurrencyWidgetProvider.PREVIOUS_ACTION == action)
                position = position.decrease()

            val currencyData = currencyList[position]
            CurrencyWidgetProvider.updateWidget(this, currencyData)
        }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    private fun fetchData() {
        runBlocking {
            currencyList = currencyDao.getCurrencyData()
        }
    }
}