package com.bpapps.matrix_bakshaevpeter.model.repository

import android.os.Handler
import android.os.Looper
import com.bpapps.matrix_bakshaevpeter.MainApplication
import com.bpapps.matrix_bakshaevpeter.model.datamodel.Result
import com.google.gson.Gson
import java.io.InputStream

class AssetDataFetcher {

    fun loadDataFromAsset(callBack: LoadAssetListener?) {
        Thread(Runnable {
            try {

                //throw java.lang.Exception("Debug Test")

                var json: String? = null

                val inputStream: InputStream? =
                    MainApplication.applicationContext?.assets?.open(JSON_FILE_NAME)
                json = inputStream?.bufferedReader().use { it?.readText() }


                val gson = Gson()
                val result: Result = gson.fromJson(json, Result::class.java)

                callBack?.let { it ->
                    Handler(Looper.getMainLooper()).post {
                        it.onSuccess(result)
                    }
                }
            } catch (e: Exception) {
                callBack?.onFailure(e)
            }
        }).run()
    }

    companion object {
        private const val JSON_FILE_NAME = "jsonObject.json"

        private const val TAG = "TAG.AssetDataFetcher"
    }

    interface LoadAssetListener {
        fun onSuccess(result: Result)
        fun onFailure(error: Throwable)
    }
}