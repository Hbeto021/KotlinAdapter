package com.hbeto021.module.kotlinadapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class RecyclerViewAdapter(
    private val list: ArrayList<AnyObject>
) : RecyclerView.Adapter<RecyclerViewAdapterViewHolder>() {

     var listener: OnClickInterface? = null



    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): RecyclerViewAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return RecyclerViewAdapterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun add(vararg items: AnyObject) {
        this.list.addAll(items)
        notifyDataSetChanged()
    }

    fun clear() {
        this.list.clear()
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(viewHolder: RecyclerViewAdapterViewHolder, position: Int) {
        val anyObject = list[position]
        viewHolder.bindView(anyObject)
        viewHolder.itemView.setOnClickListener{
            listener?.onClickItem(position)
        }


    }

    interface OnClickInterface {
        fun onClickItem(position: Int)
    }


}