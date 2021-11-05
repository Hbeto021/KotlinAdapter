package com.hbeto021.module.kotlinadapter.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hbeto021.module.kotlinadapter.R
import com.hbeto021.module.kotlinadapter.model.AnyObject
import kotlinx.android.synthetic.main.item_view.view.*

class RecyclerViewAdapter(
    private val onClick: (AnyObject) -> Unit
) : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewAdapterViewHolder>() {

    private val list by lazy {
        mutableListOf<AnyObject>()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): RecyclerViewAdapterViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_view, parent, false)
        return RecyclerViewAdapterViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(viewHolder: RecyclerViewAdapterViewHolder, position: Int) {
        viewHolder.bind(list[position])
    }

    fun updateList(objet: AnyObject) {
        this.list.add(objet)
        notifyDataSetChanged()
    }

    inner class RecyclerViewAdapterViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(anyObject: AnyObject){
            itemView.text_view_title.text = anyObject.title
            itemView.text_view_subtitle.text = anyObject.subTitle
            itemView.setOnClickListener {
                onClick.invoke(anyObject)
            }
        }
    }
}