package com.hbeto021.module.kotlinadapter.model

data class AnyObject (
    val title : String,
    val subTitle : String
)

fun AnyObject.isValidObject(): Boolean = title.trim().isNotEmpty() && subTitle.trim().isNotEmpty()