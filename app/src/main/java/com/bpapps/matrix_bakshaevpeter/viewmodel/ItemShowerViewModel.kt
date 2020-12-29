package com.bpapps.matrix_bakshaevpeter.viewmodel

import androidx.lifecycle.ViewModel
import com.bpapps.matrix_bakshaevpeter.model.Model
import com.bpapps.matrix_bakshaevpeter.model.datamodel.DataListObject

class ItemShowerViewModel : ViewModel() {

    private val model: Model = Model.initialize()

    var itemId: Int = 0
        set(value) {
            field = value

            dataItem = model.getItemById(value)
        }
    var dataItem: DataListObject? = null
        private set
}