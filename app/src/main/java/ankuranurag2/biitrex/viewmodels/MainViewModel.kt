package ankuranurag2.biitrex.viewmodels

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import ankuranurag2.biitrex.data.db.CurrencyData
import ankuranurag2.biitrex.models.Status
import ankuranurag2.biitrex.repository.CurrencyRepository
import kotlinx.coroutines.launch

/**
 * created by ankur on 11/3/20
 */
class MainViewModel(
    app: Application,
    private val currencyRepository: CurrencyRepository
) : AndroidViewModel(app) {

    val currencyDataList = MutableLiveData<List<CurrencyData>>()
    val isEmpty = MutableLiveData<Boolean>(true)
    val emptyMsg = MutableLiveData<String>()
    val isLoading = MutableLiveData<Boolean>(true)

    init {
        fetchCurrencyData(app.applicationContext)
    }

    private fun fetchCurrencyData(context:Context) = viewModelScope.launch {

        isLoading.postValue(true)
        val apiResponse = currencyRepository.getCurrencyData(context)
        isLoading.postValue(false)

        if (apiResponse.status == Status.SUCCESS) {
            isEmpty.postValue(false)
            currencyDataList.postValue(apiResponse.data)
        } else {
            isEmpty.postValue(true)
            emptyMsg.postValue(apiResponse.msg)
        }
    }
}