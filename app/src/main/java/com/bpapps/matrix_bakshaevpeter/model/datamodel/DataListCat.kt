package com.bpapps.matrix_bakshaevpeter.model.datamodel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DataListCat(
    @SerializedName("CatId")
    @Expose
    val catId: Integer,

    @SerializedName("CTitle")
    @Expose
    val cTitleString: String
)