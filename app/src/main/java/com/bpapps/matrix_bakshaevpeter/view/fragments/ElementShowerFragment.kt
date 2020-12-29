package com.bpapps.matrix_bakshaevpeter.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bpapps.matrix_bakshaevpeter.R
import com.bpapps.matrix_bakshaevpeter.viewmodel.ElementShowerViewModel
import com.squareup.picasso.Picasso


class ElementShowerFragment : Fragment() {
    private val viewModel: ElementShowerViewModel by viewModels()

    private lateinit var ivListItem: AppCompatImageView
    private lateinit var tvListItemTitle: AppCompatTextView
    private lateinit var tvListItemSubTitle: AppCompatTextView

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
        val view: View = inflater.inflate(R.layout.fragment_element_shower, container, false)

        ivListItem = view.findViewById(R.id.ivListItem)
        tvListItemTitle = view.findViewById(R.id.tvListItemTitle)
        tvListItemSubTitle = view.findViewById(R.id.tvListItemSubTitle)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(viewModel.dataItem != null) {
            Picasso.get().load(viewModel.dataItem?.imag).fit().centerInside().error(R.mipmap.ic_error)
                .into(ivListItem)

            tvListItemTitle.text = viewModel.dataItem?.title
            tvListItemSubTitle.text = viewModel.dataItem?.sTitle
        } else {
            tvListItemTitle.text = viewModel.noItemMsg
            tvListItemSubTitle.text = viewModel.noItemMsg
        }
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