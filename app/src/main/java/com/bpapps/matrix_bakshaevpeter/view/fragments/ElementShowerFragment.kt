package com.bpapps.matrix_bakshaevpeter.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bpapps.matrix_bakshaevpeter.R
import com.bpapps.matrix_bakshaevpeter.viewmodel.ItemShowerViewModel


class ElementShowerFragment : Fragment() {

    private val viewModel: ItemShowerViewModel by viewModels()

    private lateinit var ivListItem: AppCompatImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { bundle ->
            val id: Int = bundle.getInt(ElementShowerFragment.ARG_PARAM_ELEMENT_ID, 0)
            viewModel.itemId = id
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_element_shower, container, false)
    }

    companion object {
        const val FRAGMENT_TAG = "ElementShowerFragment.FRAGMENT_TAG"
        const val FRAGMENT_STACK_TAG = "ElementShowerFragment.FRAGMENT_STACK_TAG"
        private const val ARG_PARAM_ELEMENT_ID = "ARG_PARAM_ELEMENT_ID"


        @JvmStatic
        fun newInstance(itemId: Int) =
            ElementShowerFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM_ELEMENT_ID, itemId)
                }
            }
    }
}