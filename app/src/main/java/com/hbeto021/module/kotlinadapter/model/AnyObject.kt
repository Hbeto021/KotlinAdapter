package com.hbeto021.module.kotlinadapter

data class AnyObject (
    val title : String,
    val subTitle : String
)

fun AnyObject.isValidObject(): Boolean = title.isNotEmpty() && subTitle.isNotEmpty()