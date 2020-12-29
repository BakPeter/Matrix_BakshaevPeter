package com.bpapps.matrix_bakshaevpeter

import android.app.Application
import android.content.Context

class MainApplication : Application() {
    init {
        instance = this
    }

    companion object {
        private var instance: MainApplication? = null

        var applicationContext: Context? = null
            private set
            get() = instance?.applicationContext

    }
}