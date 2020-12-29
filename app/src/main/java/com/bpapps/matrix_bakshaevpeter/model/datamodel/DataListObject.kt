package com.bpapps.matrix_bakshaevpeter.model.datamodel

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class DataListObject(
    @SerializedName("CatId")
    @Expose
    private val catId: Int? = null,

    @SerializedName("Title")
    @Expose
    private val title: String? = null,

    @SerializedName("STitle")
    @Expose
    private val sTitle: String? = null,

    @SerializedName("Imag")
    @Expose
    private val imag: String? = null,

    @SerializedName("Id")
    @Expose
    private val id: Int? = null,

    @SerializedName("DataListAddr")
    @Expose
    private val dataListAddr: List<DataListAddr>? = null,

    @SerializedName("NOV")
    @Expose
    private val nOV: String? = null,

    @SerializedName("ClET")
    @Expose
    private val clET: Boolean? = null
)