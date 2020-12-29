package com.bpapps.matrix_bakshaevpeter.viewmodel

import androidx.lifecycle.ViewModel
import com.bpapps.matrix_bakshaevpeter.model.Model
import com.bpapps.matrix_bakshaevpeter.model.datamodel.DataListObject
import com.bpapps.matrix_bakshaevpeter.model.datamodel.Result

class BenefitsViewModel : ViewModel() {
    private val model: Model = Model.initialize()

    var data: Result? = null
        private set

    var cat1Data: ArrayList<DataListObject> = arrayListOf()
    var cat2Data: ArrayList<DataListObject> = arrayListOf()
    var cat3Data: ArrayList<DataListObject> = arrayListOf()
    var cat4Data: ArrayList<DataListObject> = arrayListOf()
    var cat5Data: ArrayList<DataListObject> = arrayListOf()

    private var callBack: DataUpdatedListener? = null

    fun loadData() {
        model.loadData(object : Model.LoadDataListener {
            override fun onSuccess(result: Result) {
                data = result
                updateItemsDataByCategory()
                callBack?.onLoadSuccess(result)
            }

            override fun onFailure(error: Throwable) {
                callBack?.onFailure(error)
            }
        })
    }

    interface DataUpdatedListener {
        fun onLoadSuccess(result: com.bpapps.matrix_bakshaevpeter.model.datamodel.Result)
        fun onFailure(error: Throwable)
    }

    fun registerForLoadDataListener(callBack: DataUpdatedListener?) {
        this.callBack = callBack
    }

    fun unRegisterForLoadDataListener() {
        this.callBack = null
    }

    fun updateItemsDataByCategory() {
        data?.dataObject?.dataListObject?.forEach { item ->
            when (item.catId) {
                1 -> cat1Data.add(item)
                2 -> cat2Data.add(item)
                3 -> cat3Data.add(item)
                4 -> cat4Data.add(item)
                5 -> cat5Data.add(item)
            }
        }
    }
}