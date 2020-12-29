package com.bpapps.matrix_bakshaevpeter.model.repository

import com.bpapps.matrix_bakshaevpeter.model.datamodel.Result

class Repository {

    private val assetDataFetcher: AssetDataFetcher = AssetDataFetcher()

    fun loadData(callBack: LoadAssetListener) {
        assetDataFetcher.loadDataFromAsset(object : AssetDataFetcher.LoadAssetListener {
            override fun onSuccess(result: Result) {
                callBack.onSuccess(result)
            }

            override fun onFailure(error: Throwable) {
                callBack.onFailure(error)
            }
        })
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