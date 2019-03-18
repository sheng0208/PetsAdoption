package com.billy.petsadoption.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.billy.petsadoption.model.Pet
import com.billy.petsadoption.R
import com.billy.petsadoption.databinding.ItemPetsBinding
import com.bumptech.glide.Glide

class MyAdapter(var context: Context, var list: List<Pet>): RecyclerView.Adapter<MyAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = DataBindingUtil.inflate<ItemPetsBinding>(LayoutInflater.from(parent.context),
            R.layout.item_pets,
            parent,
            false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.pet = list.get(position)
        Glide.with(context)
            .load(list.get(position).album_file)
            .placeholder(R.drawable.no_img)
            .centerInside()
            .into(holder.binding.petImg)

    }

    class ViewHolder: RecyclerView.ViewHolder {
        var binding: ItemPetsBinding
            get() = field
            set(value) { field = value }

        constructor(binding: ItemPetsBinding): super(binding.root) {
            this.binding = binding
        }

    }
}