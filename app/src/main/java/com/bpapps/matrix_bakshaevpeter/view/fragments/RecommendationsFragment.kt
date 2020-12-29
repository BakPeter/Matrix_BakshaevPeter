package com.bpapps.matrix_bakshaevpeter.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bpapps.matrix_bakshaevpeter.R
import com.bpapps.matrix_bakshaevpeter.viewmodel.RecommendationsViewModel
import kotlinx.android.synthetic.main.fragment_benefits.*

class RecommendationsFragment : Fragment() {
    private val viewModel: RecommendationsViewModel by viewModels()

    companion object {
        fun newInstance() = RecommendationsFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.recommendations_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProviders.of(this).get(RecommendationsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}