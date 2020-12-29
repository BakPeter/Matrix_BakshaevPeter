package com.bpapps.matrix_bakshaevpeter.model.datamodel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DataObject(
    @SerializedName("DataListObject")
    @Expose
    val dataListObject: List<DataListObject>? = null,

    @SerializedName("DataListCat")
    @Expose
    val dataListCat: List<DataListCat>? = null
)