package com.example.superhero

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.superhero.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

class HeroAdapter (val superhero:List<SuperHero>):RecyclerView.Adapter<
        HeroAdapter.HeroHolder>(){

    class HeroHolder(val view:View):RecyclerView.ViewHolder(view) {
        val binding = ItemSuperheroBinding.bind(view)
        fun render(superHero: SuperHero) {
            Picasso.get().load(superHero.image).into(binding.ivHero)
            binding.tvSuperHeroName.text = superHero.superHeroname
            binding.tvRealName.text = superHero.realName
            binding.tvPublisher.text = superHero.publisher
            binding.root.setOnClickListener { Toast.makeText(view.context,"${superHero.superHeroname} is the BEST!", Toast.LENGTH_LONG).show() }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        return HeroHolder(layoutInflater.inflate(R.layout.item_superhero,parent,false))
    }

    override fun onBindViewHolder(holder: HeroHolder, position: Int) {
        holder.render(superhero[position])
    }

    override fun getItemCount(): Int {
        return superhero.size
    }

}