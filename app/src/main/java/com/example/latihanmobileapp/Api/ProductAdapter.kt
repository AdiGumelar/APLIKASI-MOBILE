package com.example.latihanmobileapp.Api

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.latihanmobileapp.R

class ProductAdapter(private val productList: List<Product>, private val onProductItemClickListener: OnProductItemClickListener) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    class ViewHolder(itemView: View,private val onProductItemClickListener: OnProductItemClickListener,
                     private val productList: List<Product> ) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val productImageView: ImageView = itemView.findViewById(R.id.productImageView)
        val productNameTextView: TextView = itemView.findViewById(R.id.productNameTextView)
        val productPriceTextView: TextView = itemView.findViewById(R.id.productPriceTextView)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                val clickedProduct = productList[position]
                onProductItemClickListener.onProductItemClick(clickedProduct)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ViewHolder(view, onProductItemClickListener, productList)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = productList[position]

        holder.productNameTextView.text = product.title
        holder.productPriceTextView.text = "$${product.price}"

        Glide.with(holder.itemView.context)
            .load(product.image)
            .into(holder.productImageView)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    interface OnProductItemClickListener {
        fun onProductItemClick(product: Product)
    }
}