package com.bpapps.matrix_bakshaevpeter.model.datamodel

import android.graphics.Bitmap
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class DataListObject(
    @SerializedName("CatId")
    @Expose
    val catId: Int? = null,

    @SerializedName("Title")
    @Expose
    val title: String? = null,

    @SerializedName("STitle")
    @Expose
    val sTitle: String? = null,

    @SerializedName("Imag")
    @Expose
    val imag: String? = null,

    @SerializedName("Id")
    @Expose
    val id: Int? = null,

    @SerializedName("DataListAddr")
    @Expose
    val dataListAddr: List<DataListAddr>? = null,

    @SerializedName("NOV")
    @Expose
    val nOV: String? = null,

    @SerializedName("ClET")
    @Expose
    val clET: Boolean? = null,

    var imgBitmap: Bitmap? = null
)