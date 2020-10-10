package ankuranurag2.biitrex.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import ankuranurag2.biitrex.R
import ankuranurag2.biitrex.data.db.CurrencyData

/**
 * created by ankur on 14/3/20
 */
class CurrencyWidgetProvider : AppWidgetProvider() {

    override fun onUpdate(
        context: Context?,
        appWidgetManager: AppWidgetManager?,
        appWidgetIds: IntArray?
    ) {
        val intent = Intent(context?.applicationContext, CurrencyService::class.java)
        context?.startService(intent)
    }

    companion object {
        const val NEXT_ACTION = "next_action"
        const val PREVIOUS_ACTION = "prev_action"

        fun updateWidget(context: Context,currencyData: CurrencyData){
            val nextIntent = getPendingIntent(context, NEXT_ACTION)
            val prevIntent = getPendingIntent(context, PREVIOUS_ACTION)
            val remoteViews = RemoteViews(context.packageName, R.layout.currency_widget).apply {
                currencyData.run {
                    setTextViewText(R.id.currency_tv, currency)
                    setTextViewText(R.id.currency_long_tv, currencyLong)
                    setTextViewText(R.id.txn_tv, (String.format("%.6f", txFee)))

                    setOnClickPendingIntent(R.id.next_btn, nextIntent)
                    setOnClickPendingIntent(R.id.prev_btn, prevIntent)
                }
            }

            val manager = AppWidgetManager.getInstance(context)
            val component = ComponentName(context, CurrencyWidgetProvider::class.java)
            manager.updateAppWidget(component, remoteViews)
        }

        private fun getPendingIntent(context: Context?, action: String): PendingIntent {
            val intent = Intent(context, CurrencyService::class.java)
            intent.action = action
            return PendingIntent.getService(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        }
    }
}