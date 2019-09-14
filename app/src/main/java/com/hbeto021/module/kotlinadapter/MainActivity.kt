package com.hbeto021.module.kotlinadapter

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_dialog.view.*

class MainActivity : AppCompatActivity(), RecyclerViewAdapter.OnClickInterface {

    //Avoid initialize objects in Activities constructors, use lazy init
    private val list by lazy { ArrayList<AnyObject>() }
    // adapter can be call in any time in activity, without depending of the lifecycle
    // lambda expression can be filed with method reference (::example)
    private val adapter by lazy { val adapter = RecyclerViewAdapter(list)
    adapter.listener = this
    adapter
    }

    //A Exaple of nullable field
    private var dialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        recycler_view_main.adapter = adapter
    }

    private fun initViews() {
        fab_main.setOnClickListener {
            showDialog()
        }
    }

    private fun onDialogClickListener(view: View) {
        if (areFieldsNotEmpty(view)) {
            adapter.add(
                AnyObject(
                    view.edit_text_title.text.toString(),
                    view.edit_text_sub_title.text.toString()
                )
            )
            dialog?.dismiss()

        } else {
            Toast.makeText(this, "Preencha todos campos!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showDialog() {
        val builder = AlertDialog.Builder(this)
        val view = View.inflate(this, R.layout.custom_dialog, null)
        builder.setView(view)
        dialog = builder.create()
        dialog?.setCanceledOnTouchOutside(false)

        view.text_view_submit.setOnClickListener{
            onDialogClickListener(view)
        }

        view.text_view_cancel.setOnClickListener {
            dialog?.dismiss()
        }

        dialog?.show()
    }

    private fun areFieldsNotEmpty(view: View) =
        (view.edit_text_title).isNotEmptyText()
                && (view.edit_text_sub_title ).isNotEmptyText()

    override fun onClickItem(position: Int) {
        Toast.makeText(this, list[position].title, Toast.LENGTH_SHORT).show()
    }

}
