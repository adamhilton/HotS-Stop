package com.nonnulldev.hotsstop.ui.main.recyclerview

import android.view.ViewGroup
import android.view.LayoutInflater
import android.support.v7.widget.RecyclerView
import com.nonnulldev.hotsstop.R
import com.nonnulldev.hotsstop.data.model.Hero


class HeroesAdapter(private val heroes: List<Hero>) : RecyclerView.Adapter<HeroesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.hero, parent, false)

        val viewHolder = HeroesViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holderHeroes: HeroesViewHolder, position: Int) {
        val hero = heroes[position]
        holderHeroes.name.text = hero.PrimaryName
        holderHeroes.group.text = hero.Group
        holderHeroes.subgroup.text = hero.SubGroup
    }

    override fun getItemCount(): Int {
        return heroes.count()
    }
}