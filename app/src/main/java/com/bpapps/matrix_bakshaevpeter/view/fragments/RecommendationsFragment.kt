package com.bpapps.matrix_bakshaevpeter.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.bpapps.matrix_bakshaevpeter.R
import com.bpapps.matrix_bakshaevpeter.model.datamodel.DataListCat
import com.bpapps.matrix_bakshaevpeter.model.datamodel.Result
import com.bpapps.matrix_bakshaevpeter.view.adapters.ItemsShowerAdapter
import com.bpapps.matrix_bakshaevpeter.viewmodel.RecommendationsViewModel

class RecommendationsFragment : Fragment(), RecommendationsViewModel.DataUpdatedListener,
    ItemsShowerAdapter.OnItemClickListener {
    private val viewModel: RecommendationsViewModel by viewModels()

    private lateinit var tvCategory1: AppCompatTextView
    private lateinit var tvCategory2: AppCompatTextView
    private lateinit var tvCategory3: AppCompatTextView
    private lateinit var tvCategory4: AppCompatTextView
    private lateinit var tvCategory5: AppCompatTextView

    private lateinit var rvCategory1: RecyclerView
    private lateinit var rvCategory2: RecyclerView
    private lateinit var rvCategory3: RecyclerView
    private lateinit var rvCategory4: RecyclerView
    private lateinit var rvCategory5: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.recommendations_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)

        viewModel.data?.let { data ->
            updateViews(data)
        }
    }

    private fun updateViews(data: Result) {
        updateTVCategoriesNames(data.dataObject?.dataListCat!!)
        updateRVItems()
    }

    private fun initViews(view: View) {
        tvCategory1 = view.findViewById(R.id.tvCategory1Name)
        tvCategory2 = view.findViewById(R.id.tvCategory2Name)
        tvCategory3 = view.findViewById(R.id.tvCategory3Name)
        tvCategory4 = view.findViewById(R.id.tvCategory4Name)
        tvCategory5 = view.findViewById(R.id.tvCategory5Name)

        rvCategory1 = view.findViewById(R.id.rvCategory1)
        rvCategory1.adapter = ItemsShowerAdapter(viewModel.cat1Data, this)
        rvCategory1.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        PagerSnapHelper().attachToRecyclerView(rvCategory1)


        rvCategory2 = view.findViewById(R.id.rvCategory2)
        rvCategory2.adapter = ItemsShowerAdapter(viewModel.cat2Data, this)
        rvCategory2.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        PagerSnapHelper().attachToRecyclerView(rvCategory2)


        rvCategory3 = view.findViewById(R.id.rvCategory3)
        rvCategory3.adapter = ItemsShowerAdapter(viewModel.cat3Data, this)
        rvCategory3.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        PagerSnapHelper().attachToRecyclerView(rvCategory3)

        rvCategory4 = view.findViewById(R.id.rvCategory4)
        rvCategory4.adapter = ItemsShowerAdapter(viewModel.cat4Data, this)
        rvCategory4.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        PagerSnapHelper().attachToRecyclerView(rvCategory4)

        rvCategory5 = view.findViewById(R.id.rvCategory5)
        rvCategory5.adapter = ItemsShowerAdapter(viewModel.cat5Data, this)
        rvCategory5.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        PagerSnapHelper().attachToRecyclerView(rvCategory5)
    }

    private fun updateTVCategoriesNames(categories: List<DataListCat>) {
        tvCategory1.text = categories[0].cTitleString
        tvCategory2.text = categories[1].cTitleString
        tvCategory3.text = categories[2].cTitleString
        tvCategory4.text = categories[3].cTitleString
        tvCategory5.text = categories[4].cTitleString
    }

    private fun updateRVItems() {
        rvCategory1.adapter?.notifyDataSetChanged()
        rvCategory2.adapter?.notifyDataSetChanged()
        rvCategory3.adapter?.notifyDataSetChanged()
        rvCategory4.adapter?.notifyDataSetChanged()
        rvCategory5.adapter?.notifyDataSetChanged()
    }

    override fun onResume() {
        super.onResume()
        viewModel.registerForLoadDataListener(this)

        if (viewModel.data == null) {
            viewModel.loadData()
        }
    }

    override fun onStop() {
        super.onStop()
        viewModel.unRegisterForLoadDataListener()
    }

    companion object {
        private const val TAG = "TAG.RecommendationsFragment"

        fun newInstance() = RecommendationsFragment()
    }

    override fun onLoadSuccess(result: Result) {
//        Log.d(TAG, "onLoadSuccess: $result")
        updateViews(result)
    }

    override fun onFailure(error: Throwable) {
        Log.d(TAG, "onLoadSuccess: ${error.message}")
    }

    override fun onItemClick(id: Int) {
//        Toast.makeText(requireContext(), "id = $position", Toast.LENGTH_SHORT).show()
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(
                R.id.main_fragment_container,
                ElementShowerFragment.newInstance(id),
                ElementShowerFragment.FRAGMENT_TAG
            )
            .addToBackStack(ElementShowerFragment.FRAGMENT_STACK_TAG)
            .commit()
    }
}