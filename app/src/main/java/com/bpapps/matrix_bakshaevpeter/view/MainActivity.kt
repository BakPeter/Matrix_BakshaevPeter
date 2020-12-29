package com.bpapps.matrix_bakshaevpeter.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bpapps.matrix_bakshaevpeter.R
import com.bpapps.matrix_bakshaevpeter.view.fragments.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(
                R.id.main_fragment_container,
                MainFragment.newInstance(),
                MainFragment.FRAGMENT_TAG
            )
            .addToBackStack(MainFragment.FRAGMENT_STACK_TAG)
            .commit()
    }
}