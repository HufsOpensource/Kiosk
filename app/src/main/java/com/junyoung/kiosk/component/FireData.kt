package com.junyoung.kiosk.component

import java.io.Serializable

class FireData (
    val title: String? = null,
    val description : String?=null,
    val image : String?=null,
    val companyname:String?=null,
    val cost : Long?=0
):Serializable{}
