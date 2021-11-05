package com.hbeto021.module.kotlinadapter.view

import android.content.Context
import android.support.v7.app.AlertDialog
import android.view.View
import com.hbeto021.module.kotlinadapter.R
import kotlinx.android.synthetic.main.custom_dialog.view.*

class CustomDialog(
    private val context: Context,
    private val onSubmit: (String, String) -> Unit
) {

    fun show() {
        val builder = AlertDialog.Builder(context)
        val view = View.inflate(context, R.layout.custom_dialog, null)

        builder.setView(view)
        val dialog = createDialog(builder)

        initView(view, dialog)

        dialog.show()
    }

    private fun initView(view: View, dialog: AlertDialog) {
        view.text_view_submit.setOnClickListener {
            onSubmit.invoke(
                view.edit_text_title.text.toString(),
                view.edit_text_sub_title.text.toString()
            )
            dialog.dismiss()
        }
        view.text_view_cancel.setOnClickListener {
            dialog.dismiss()
        }
    }

    private fun createDialog(builder: AlertDialog.Builder) : AlertDialog = builder.create()
}