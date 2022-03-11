package com.example.tarea01guarga_links.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tarea01guarga_links.databinding.MascotasFilaBinding
import com.example.tarea01guarga_links.model.Links

class LinksAdapter : RecyclerView.Adapter<LinksAdapter.LinkViewHolder>() {

    private var listaLinks = emptyList<Links>()

    inner class LinkViewHolder(private val itemBinding: MascotasFilaBinding):
    RecyclerView.ViewHolder(itemBinding.root){
        fun bind(link: Links){
            itemBinding.tvNombre.text = link.nombre
            itemBinding.tvURL.text = link.URL
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LinkViewHolder {
        val itemBinding = MascotasFilaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return LinkViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: LinkViewHolder, position: Int) {
        val linkActual = listaLinks[position]
        holder.bind(linkActual)
    }

    override fun getItemCount(): Int {
        return listaLinks.size
    }

    fun setData(link: List<Links>){
        this.listaLinks = link
        notifyDataSetChanged()
    }
}