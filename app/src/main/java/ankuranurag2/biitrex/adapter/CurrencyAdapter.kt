package ankuranurag2.biitrex.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ankuranurag2.biitrex.data.db.CurrencyData
import ankuranurag2.biitrex.databinding.ItemCurrencyBinding

/**
 * created by ankur on 11/3/20
 */
class CurrencyAdapter : ListAdapter<CurrencyData, RecyclerView.ViewHolder>(CurrencyDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CurrencyVH(
            ItemCurrencyBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CurrencyVH).bindData(getItem(position))
    }

    class CurrencyVH(private val binding: ItemCurrencyBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: CurrencyData) {
            binding.apply {
                data = item
                executePendingBindings()
            }
        }
    }
}

private class CurrencyDiffCallback : DiffUtil.ItemCallback<CurrencyData>() {
    override fun areItemsTheSame(oldItem: CurrencyData, newItem: CurrencyData): Boolean {
        return newItem.currency == oldItem.currency
    }

    override fun areContentsTheSame(oldItem: CurrencyData, newItem: CurrencyData): Boolean {
        return newItem.currency == oldItem.currency
    }
}