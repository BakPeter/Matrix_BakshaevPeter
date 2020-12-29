package com.bpapps.matrix_bakshaevpeter.model.datamodel

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class Result(
    @SerializedName("DataObject")
    @Expose
    val dataObject: DataObject? = null
)