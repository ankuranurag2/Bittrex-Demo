package ankuranurag2.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import ankuranurag2.assignment.databinding.ActivityMainBinding
import ankuranurag2.assignment.viewmodels.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel:MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        setSupportActionBar(binding.toolbar)

        viewModel.currencyDataList.observe(this, Observer {
            it?.let{
                binding.isEmpty=false

            }
        })

        viewModel.emptyMsg.observe(this, Observer {
            it?.let{
                binding.isEmpty=true
                binding.emptyTv.text=it
            }
        })
    }
}
