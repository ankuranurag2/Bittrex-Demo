package ankuranurag2.assignment.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import ankuranurag2.assignment.data.db.CurrencyData
import ankuranurag2.assignment.models.Status
import ankuranurag2.assignment.repository.CurrencyRepository
import ankuranurag2.assignment.utils.checkForInternet
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
        fetchCurrencyData(app.applicationContext.checkForInternet())
    }

    private fun fetchCurrencyData(isConnected: Boolean) = viewModelScope.launch {

        isLoading.postValue(true)
        val apiResponse = currencyRepository.getCurrencyData(isConnected)
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