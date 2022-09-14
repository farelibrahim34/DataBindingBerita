package com.example.databindingberita

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.databindingberita.databinding.ItemBeritaBinding

class BeritaAdapter(var listBerita: ArrayList<DataBerita>, private val mlistener: MainActivity):RecyclerView.Adapter<BeritaAdapter.ViewHolder>() {
    class ViewHolder(var binding: ItemBeritaBinding): RecyclerView.ViewHolder(binding.root) {

        fun data(itemData: DataBerita, listener: MainActivity){
            binding.databerita = itemData
            binding.detailklik = listener

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemBeritaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.data(listBerita[position],mlistener)
    }

    override fun getItemCount(): Int {
        return listBerita.size
    }
    interface ItemClickListener{
        fun onItemClicked(detail : DataBerita)
    }
}