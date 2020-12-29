package com.bpapps.matrix_bakshaevpeter.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.bpapps.matrix_bakshaevpeter.R
import com.bpapps.matrix_bakshaevpeter.view.Util
import com.bpapps.matrix_bakshaevpeter.view.adapters.AppViewPagerAdapter
import com.bpapps.matrix_bakshaevpeter.viewmodel.BenefitsViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

private const val TAG = "TAG.MainFragment"

class MainFragment : Fragment() {

    private val viewModel: BenefitsViewModel by viewModels()

    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPager = view.findViewById(R.id.viewPager)
        viewPager.isUserInputEnabled = false
        viewPager.adapter = AppViewPagerAdapter(this)

        val tabLayout: TabLayout = view.findViewById(R.id.tabLayout)
        TabLayoutMediator(
            tabLayout,
            viewPager,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                when (position) {
                    Util.BENEFITS -> tab.text = getString(R.string.benefits)
                    Util.RECOMMENDATIONS -> tab.text = getString(R.string.recommendations)
                    Util.TREATS -> tab.text = getString(R.string.treats)
                    Util.PREFERRED -> tab.text = getString(R.string.preferred)
                }
            }).also { mediator ->
            mediator.attach()
        }
    }

    companion object {
        const val FRAGMENT_TAG = "MainFragment.FRAGMENT_TAG"
        const val FRAGMENT_STACK_TAG = "MainFragment.FRAGMENT_STACK_TAG"
        @JvmStatic
        fun newInstance() =
            MainFragment()

    }
}