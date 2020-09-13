package com.konovalovk.techno.guessit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.konovalovk.techno.guessit.R

class ViewPagerAdapter() : RecyclerView.Adapter<PagerVH>() {

    private val digit = (0..9).toList().toIntArray()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerVH =
        PagerVH(LayoutInflater.from(parent.context).inflate(R.layout.digit_item, parent, false))

    override fun getItemCount(): Int = digit.size

    override fun onBindViewHolder(holder: PagerVH, position: Int) = holder.itemView.run {
        (this as? TextView)?.text = digit[position].toString()
    }
}

class PagerVH(itemView: View) : RecyclerView.ViewHolder(itemView)