package com.hbeto021.module.kotlinadapter

import android.widget.EditText


fun EditText.isEmptyText() = this.text.toString().isEmpty()

fun EditText.isNotEmptyText() = this.text.toString().isNotEmpty()


