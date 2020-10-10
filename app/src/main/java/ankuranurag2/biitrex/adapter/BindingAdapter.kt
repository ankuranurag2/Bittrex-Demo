package ankuranurag2.biitrex.adapter

import android.widget.TextView
import androidx.databinding.BindingAdapter

/**
 * created by ankur on 11/3/20
 */
@BindingAdapter("setDouble")
fun setDouble(view:TextView,doubleValue:Double?){
    view.text=(String.format("%.6f",doubleValue))
}