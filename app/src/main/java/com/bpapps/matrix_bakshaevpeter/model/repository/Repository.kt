package com.bpapps.matrix_bakshaevpeter.model.repository

import com.bpapps.matrix_bakshaevpeter.model.datamodel.DataListObject
import com.bpapps.matrix_bakshaevpeter.model.datamodel.Result

class Repository {

    private val assetDataFetcher: AssetDataFetcher = AssetDataFetcher()

    private var data: Result? = null

    fun loadData(callBack: LoadAssetListener) {
        if (data == null) {
            assetDataFetcher.loadDataFromAsset(object : AssetDataFetcher.LoadAssetListener {
                override fun onSuccess(result: Result) {
                    data = result
                    callBack.onSuccess(result)
                }

                override fun onFailure(error: Throwable) {
                    callBack.onFailure(error)
                }
            })
        } else {
            callBack.onSuccess(data!!)
        }
    }

    fun gtItemById(id: Int): DataListObject? {
        return if (data == null) {
            null
        } else {
            getItemById(id)
        }
    }

    private fun getItemById(id: Int): DataListObject? {
        data?.dataObject?.dataListObject?.forEach { item: DataListObject ->
            if (item.id == id) {
                return item
            }
        }

        return null
    }

    companion object {
        private var instance: Repository? = null

        fun getInstance(): Repository {
            if (instance == null) {
                instance = Repository()
            }

            return instance!!
        }
    }

    interface LoadAssetListener {
        fun onSuccess(result: Result)
        fun onFailure(error: Throwable)
    }
}