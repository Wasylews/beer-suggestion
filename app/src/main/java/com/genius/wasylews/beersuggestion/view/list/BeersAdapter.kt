package com.genius.wasylews.beersuggestion.view.list

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.genius.wasylews.beersuggestion.R
import com.genius.wasylews.beersuggestion.databinding.ItemBeerBinding
import com.genius.wasylews.beersuggestion.domain.Beer

@BindingAdapter(value = ["setImageUrl"])
fun ImageView.bindImageUrl(url: String?) {
    if (url != null && url.isNotBlank()) {
        Glide.with(this)
            .load(url)
            .into(this)
    }
}

class BeersAdapter :
    BaseQuickAdapter<Beer, BaseDataBindingHolder<ItemBeerBinding>>(R.layout.item_beer) {

    override fun convert(holder: BaseDataBindingHolder<ItemBeerBinding>, item: Beer) {
        holder.dataBinding?.item = item
        holder.dataBinding?.executePendingBindings()
    }
}