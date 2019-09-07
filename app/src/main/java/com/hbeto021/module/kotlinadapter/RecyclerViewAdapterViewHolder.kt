package com.hbeto021.module.kotlinadapter

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.item_view.view.*

class RecyclerViewAdapterViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindView(anyObject: AnyObject){
        itemView.text_view_title.text = anyObject.title
        itemView.text_view_subtitle.text = anyObject.subTitle
    }

    fun onClickItem(position: Int, onClickInterface : RecyclerViewAdapter.OnClickInterface) {
        itemView.setOnClickListener {
            onClickInterface.onClickItem(position)
        }
    }

}