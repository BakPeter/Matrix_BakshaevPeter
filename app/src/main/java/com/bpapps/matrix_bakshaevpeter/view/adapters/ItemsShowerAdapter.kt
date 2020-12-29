package com.bpapps.matrix_bakshaevpeter.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bpapps.matrix_bakshaevpeter.R
import com.bpapps.matrix_bakshaevpeter.model.datamodel.DataListObject
import com.squareup.picasso.Picasso

class ItemsAdapter(private val dataSet: ArrayList<DataListObject>) :
    RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)

        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val dataItem: DataListObject = dataSet[position]

        Picasso.get().load(dataItem.imag).fit().centerInside().error(R.mipmap.ic_error)
            .into(holder.ivListItem)

        holder.tvListItemTitle.text = dataItem.title
        holder.tvListItemSubTitle.text = dataItem.sTitle
    }

    class ItemViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val ivListItem: AppCompatImageView = v.findViewById(R.id.ivListItem)
        val tvListItemTitle: AppCompatTextView = v.findViewById(R.id.tvListItemTitle)
        val tvListItemSubTitle: AppCompatTextView = v.findViewById(R.id.tvListItemSubTitle)

    }
}