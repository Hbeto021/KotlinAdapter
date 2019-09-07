package com.hbeto021.module.kotlinadapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class RecyclerViewAdapter(var onClickInterface : OnClickInterface) : RecyclerView.Adapter<RecyclerViewAdapterViewHolder>(){

    private val list = ArrayList<AnyObject>()

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): RecyclerViewAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return RecyclerViewAdapterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun addItens(list : ArrayList<AnyObject>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(viewHolder: RecyclerViewAdapterViewHolder, position: Int) {
        viewHolder.bindView(list[position])
        viewHolder.onClickItem(position, onClickInterface)
    }

    interface OnClickInterface {
        fun onClickItem(position: Int)
    }


}