package com.bpapps.matrix_bakshaevpeter.model.repository

import android.graphics.Bitmap
import android.os.Handler
import android.os.Looper
import android.view.View
import com.bpapps.matrix_bakshaevpeter.MainApplication
import com.bpapps.matrix_bakshaevpeter.model.datamodel.Result
import com.google.gson.Gson
import com.nostra13.universalimageloader.core.ImageLoader
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration
import com.nostra13.universalimageloader.core.assist.FailReason
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener
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

//                val config = ImageLoaderConfiguration.Builder(MainApplication.applicationContext)
//                    .build();
//                val imageLoader = ImageLoader.getInstance()
//                imageLoader.init(config)
//                result.dataObject?.dataListObject?.forEachIndexed { index, item ->
//                    imageLoader.loadImage(item.imag, object : ImageLoadingListener {
//                        override fun onLoadingComplete(
//                            imageUri: String?,
//                            view: View?,
//                            loadedImage: Bitmap?
//                        ) {
//                            item.imgBitmap = loadedImage
//                        }
//
//                        override fun onLoadingStarted(imageUri: String?, view: View?) {
//                        }
//
//                        override fun onLoadingCancelled(imageUri: String?, view: View?) {
//                        }
//
//                        override fun onLoadingFailed(
//                            imageUri: String?,
//                            view: View?,
//                            failReason: FailReason?
//                        ) {
//                            item.imgBitmap = null
//                        }
//                    })
//                }

                callBack?.let { it ->
                    Handler(Looper.getMainLooper()).post {
                        it.onSuccess(result)
                    }
                }
            } catch (error: Exception) {
                callBack?.let { it ->
                    Handler(Looper.getMainLooper()).post {
                        it.onFailure(error)
                    }
                }
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