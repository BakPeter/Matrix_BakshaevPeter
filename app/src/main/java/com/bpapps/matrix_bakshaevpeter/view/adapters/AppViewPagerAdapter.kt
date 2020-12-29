package com.bpapps.matrix_bakshaevpeter.view.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bpapps.matrix_bakshaevpeter.view.Util
import com.bpapps.matrix_bakshaevpeter.view.fragments.BenefitsFragment
import com.bpapps.matrix_bakshaevpeter.view.fragments.PreferredFragment
import com.bpapps.matrix_bakshaevpeter.view.fragments.RecommendationsFragment
import com.bpapps.matrix_bakshaevpeter.view.fragments.TreatsFragment

class AppViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            Util.BENEFITS -> BenefitsFragment.newInstance()
            Util.RECOMMENDATIONS -> RecommendationsFragment.newInstance()
            Util.TREATS -> TreatsFragment.newInstance()
            else -> {
//                Util.PREFERRED ->
                PreferredFragment.newInstance()
            }
        }
    }
}