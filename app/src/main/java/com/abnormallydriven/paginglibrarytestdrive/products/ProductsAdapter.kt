package com.abnormallydriven.paginglibrarytestdrive.products

import android.arch.paging.PagedListAdapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.abnormallydriven.paginglibrarytestdrive.R
import javax.inject.Inject


class ProductsAdapter @Inject constructor(productsDiffer: ProductDiffer) : PagedListAdapter<Product, ProductViewHolder>(productsDiffer) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ProductViewHolder(layoutInflater.inflate(R.layout.layout_product_item, parent, false))
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val safeItem = getItem(position) ?: return
        holder.bind(safeItem)
    }
}



class ProductViewHolder constructor(itemView : View): RecyclerView.ViewHolder(itemView){

    private val nameTextView = itemView.findViewById<TextView>(R.id.product_name_text_view)
    private val priceTextView = itemView.findViewById<TextView>(R.id.price_text_view)
    private val productIdTextView = itemView.findViewById<TextView>(R.id.product_id_text_view)

    fun bind(product: Product){
        nameTextView.text = product.name
        priceTextView.text = product.price
        productIdTextView.text = product.id
    }

}