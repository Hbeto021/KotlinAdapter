package com.hbeto021.module.kotlinadapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_view.view.*

class RecyclerViewAdapter(var onClickInterface : OnClickInterface) : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewAdapterViewHolder>(){

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
        viewHolder.onClickItem(position)
    }

    interface OnClickInterface {
        fun onClickItem(position: Int)
    }

    inner class RecyclerViewAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(anyObject: AnyObject){
            itemView.text_view_title.text = anyObject.title
            itemView.text_view_subtitle.text = anyObject.subTitle
        }

        fun onClickItem(position: Int) {
            itemView.setOnClickListener {
                onClickInterface.onClickItem(position)
            }
        }

    }
}