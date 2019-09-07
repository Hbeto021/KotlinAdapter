package com.hbeto021.module.kotlinadapter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.custom_dialog.*
import kotlinx.android.synthetic.main.custom_dialog.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter : RecyclerViewAdapter
    private val list = arrayListOf<AnyObject>()
    private val context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        initViews()
    }

    private fun initViews() {
        fab_main.setOnClickListener {
            showDialog()
        }
    }

    private fun initRecyclerView() {
        adapter = RecyclerViewAdapter(object : RecyclerViewAdapter.OnClickInterface{

            override fun onClickItem(position: Int) {
                Toast.makeText(context, list[position].title, Toast.LENGTH_SHORT).show()
            }
        })

        recycler_view_main.adapter = adapter
    }

    private fun showDialog() {
        val builder = AlertDialog.Builder(context)
        val view = View.inflate(context, R.layout.custom_dialog,  null)
        builder.setView(view)
        val dialog = builder.create()
        dialog.setCanceledOnTouchOutside(false)

        view.text_view_submit.setOnClickListener {

            if(view.edit_text_title.text.toString().isNotEmpty() && view.edit_text_sub_title.text.toString().isNotEmpty()){
                list.add(AnyObject(view.edit_text_title.text.toString(), view.edit_text_sub_title.text.toString()))
                adapter.addItens(list)
                dialog.dismiss()

            } else {
                Toast.makeText(context, "Preencha todos campos!",  Toast.LENGTH_SHORT).show()
            }
        }

        view.text_view_cancel.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

}
