package com.hbeto021.module.kotlinadapter.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.hbeto021.module.kotlinadapter.R
import com.hbeto021.module.kotlinadapter.model.AnyObject
import com.hbeto021.module.kotlinadapter.model.isValidObject
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        adapter = RecyclerViewAdapter(::onItemClick)
        recycler_view_main.adapter = adapter

        fab_main.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {
        CustomDialog(this, ::onSubmitDialogClick).show()
    }

    private fun onSubmitDialogClick(title: String, subTitle: String) {
        val any = AnyObject(title, subTitle)
        if (any.isValidObject()) {
            adapter.updateList(any)
        } else {
            Toast.makeText(this, "Preencha todos campos!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun onItemClick(anyObject: AnyObject) {
        Toast.makeText(this, anyObject.title, Toast.LENGTH_SHORT).show()
    }
}
