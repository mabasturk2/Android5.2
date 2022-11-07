package com.example.recyclerapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_catalog.view.*
import kotlinx.android.synthetic.main.item_product_list.view.*

class MyAdapter(var pList: ArrayList<Product>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    var onItemClick: ((Product) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_product_list, parent, false)
        return MyViewHolder(view)

    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val product = pList[position]
        holder.itemView.textView.text = product.title
        holder.itemView.imageView.setImageResource(product.image)
    }

    override fun getItemCount(): Int {
        return pList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(pList[adapterPosition])
            }
        }
    }

}
