package com.bpapps.matrix_bakshaevpeter.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bpapps.matrix_bakshaevpeter.R
import com.bpapps.matrix_bakshaevpeter.model.datamodel.Result
import com.bpapps.matrix_bakshaevpeter.viewmodel.BenefitsViewModel
import kotlinx.android.synthetic.main.fragment_benefits.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BenefitsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BenefitsFragment : Fragment(), BenefitsViewModel.LoadDataListener {

    private val viewModel: BenefitsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_benefits, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        viewModel.registerForLoadDataListener(this)

    }

    override fun onStop() {
        super.onStop()
        viewModel.unRegisterForLoadDataListener()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.loadData()
    }

    companion object {
        private const val TAG = "TAG.BenefitsFragment"

        @JvmStatic
        fun newInstance(/*param1: String, param2: String*/) =
            BenefitsFragment().apply {
            }
    }

    override fun onLoadSuccess(result: Result) {
        Log.d(TAG, "onLoadSuccess: $result")
    }

    override fun onFailure(error: Throwable) {
        Log.d(TAG, "onLoadSuccess: ${error.message}")
    }
}