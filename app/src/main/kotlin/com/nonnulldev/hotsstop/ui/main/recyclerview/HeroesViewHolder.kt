package com.nonnulldev.hotsstop.ui.main.recyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.nonnulldev.hotsstop.R


class HeroesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val context: Context

    @BindView(R.id.hero_name)
    lateinit internal var name: TextView

    init {
        ButterKnife.bind(this, itemView)
        context = itemView.context
    }
}