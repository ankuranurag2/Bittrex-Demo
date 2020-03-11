package ankuranurag2.assignment.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ankuranurag2.assignment.AssignmentApp
import ankuranurag2.assignment.data.db.CurrencyData
import ankuranurag2.assignment.models.Status
import ankuranurag2.assignment.repository.CurrencyRepository
import ankuranurag2.assignment.utils.checkForInternet
import kotlinx.coroutines.launch

/**
 * created by ankur on 11/3/20
 */
class MainViewModel(
    private val application: AssignmentApp,
    private val currencyRepository: CurrencyRepository
) : AndroidViewModel(application) {

    val currencyDataList = MutableLiveData<List<CurrencyData>>()
    val emptyMsg=MutableLiveData<String>()

    init {
        fetchCurrencyData(application.applicationContext.checkForInternet())
    }

    private fun fetchCurrencyData(isConnected: Boolean) = viewModelScope.launch {
        val apiResponse = currencyRepository.getCurrencyData(isConnected)
        if (apiResponse.status == Status.SUCCESS)
            currencyDataList.postValue(apiResponse.data)
        else
            emptyMsg.postValue(apiResponse.msg)
    }
}