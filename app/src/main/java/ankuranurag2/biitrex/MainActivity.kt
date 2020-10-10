package ankuranurag2.biitrex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import ankuranurag2.biitrex.adapter.CurrencyAdapter
import ankuranurag2.biitrex.databinding.ActivityMainBinding
import ankuranurag2.biitrex.viewmodels.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(binding.toolbar)

        val adapter = CurrencyAdapter()
        binding.currencyRv.adapter = adapter

        viewModel.currencyDataList.observe(this, Observer {
            it?.let {
                binding.isEmpty = false
                adapter.submitList(it)
            }
        })

        viewModel.isLoading.observe(this, Observer {
            binding.isLoading = it
        })

        viewModel.emptyMsg.observe(this, Observer {
            binding.isEmpty=true
            binding.emptyMsg=it
        })
    }
}
