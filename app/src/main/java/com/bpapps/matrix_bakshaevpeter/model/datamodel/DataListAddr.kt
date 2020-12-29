package com.bpapps.matrix_bakshaevpeter.model.datamodel

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class DataListAddr(
    @SerializedName("Addr")
    @Expose
    val addr: String? = null,

    @SerializedName("DAd")
    @Expose
    val dAd: String? = null
)
