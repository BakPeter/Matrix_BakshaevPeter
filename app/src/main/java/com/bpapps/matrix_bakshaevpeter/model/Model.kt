package com.bpapps.matrix_bakshaevpeter.model

import com.bpapps.matrix_bakshaevpeter.model.datamodel.DataListObject
import com.bpapps.matrix_bakshaevpeter.model.datamodel.Result
import com.bpapps.matrix_bakshaevpeter.model.repository.Repository

class Model {

    private val repository = Repository.getInstance()

    fun loadData(callback: LoadDataListener) {
        repository.loadData(object : Repository.LoadAssetListener {
            override fun onSuccess(result: Result) {
                callback.onSuccess(result)
            }

            override fun onFailure(error: Throwable) {
                callback.onFailure(error)
            }
        })
    }

    fun getItemById(id: Int): DataListObject? {
//        var retVal: DataListObject? = null
//        repository.loadData(object : Repository.LoadAssetListener {
//            override fun onSuccess(result: Result) {
//                retVal = result.dataObject?.dataListObject[]
//            }
//
//            override fun onFailure(error: Throwable) {
//                retVal = null
//            }
//
//        })

        return repository.gtItemById(id)
    }

    companion object {
        private var instance: Model? = null

        fun initialize(): Model {
            if (instance == null) {
                instance = Model()
            }

            return instance!!
        }

        fun getInstance(): Model {
            if (instance == null) {
                throw IllegalStateException("Model must be initialized")
            }

            return instance!!
        }
    }

    interface LoadDataListener {
        fun onSuccess(result: Result)
        fun onFailure(error: Throwable)
    }
}