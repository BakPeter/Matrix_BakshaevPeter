package com.bpapps.matrix_bakshaevpeter.viewmodel

import androidx.lifecycle.ViewModel
import com.bpapps.matrix_bakshaevpeter.model.Model
import com.bpapps.matrix_bakshaevpeter.model.datamodel.Result

class BenefitsViewModel : ViewModel() {
    private val model: Model = Model.initialize()

    var data: Result? = null
        private set

    private var callBack: LoadDataListener? = null

    fun loadData() {
        model.loadData(object : Model.LoadDataListener {
            override fun onSuccess(result: Result) {
                callBack?.onLoadSuccess(result)
            }

            override fun onFailure(error: Throwable) {
                callBack?.onFailure(error)
            }
        })
    }

    interface LoadDataListener {
        fun onLoadSuccess(result: com.bpapps.matrix_bakshaevpeter.model.datamodel.Result)
        fun onFailure(error: Throwable)
    }

    fun registerForLoadDataListener(callBack: LoadDataListener?) {
        this.callBack = callBack
    }


    fun unRegisterForLoadDataListener() {
        this.callBack = null
    }
}