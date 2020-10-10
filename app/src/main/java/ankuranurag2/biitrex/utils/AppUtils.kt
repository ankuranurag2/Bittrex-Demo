package ankuranurag2.biitrex.utils

import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import ankuranurag2.biitrex.BuildConfig
import ankuranurag2.biitrex.widget.CurrencyWidgetProvider

/**
 * created by ankur on 12/3/20
 */

object AppUtils {

    fun isUAT() = BuildConfig.VERSION_NAME.contains("DEV")

    fun sendNewDataBroadcast(context: Context) {
        val manager = AppWidgetManager.getInstance(context)
        val ids = manager.getAppWidgetIds(ComponentName(context, CurrencyWidgetProvider::class.java))
        val intent = Intent(AppWidgetManager.ACTION_APPWIDGET_UPDATE)
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, ids)
        context.sendBroadcast(intent)
    }
}