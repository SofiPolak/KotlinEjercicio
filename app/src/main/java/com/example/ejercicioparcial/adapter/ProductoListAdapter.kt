package com.example.ejercicioparcial.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.ejercicioparcial.R
import com.example.ejercicioparcial.entidades.Producto
import com.example.ejercicioparcial.listener.OnProductClickedListener

class ProductoListAdapter {
    private val productList: List<Producto>,
    private val onProductClickedListener: OnProductClickedListener
    ) : RecyclerView.Adapter<ProductViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_design, parent, false)
            return ProductViewHolder(view)
        }

        override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
            // De la lista, obtengo el producto basandome en la posicion de la celda en el recyclerview
            val product = productList[position]

            // Se invoca al ViewHolder para que muestre los datos del producto
            holder.bind(product)

            // Establezco un click listener en el itemview del holder. Esto seria, la vista entera del elemento {position}
            // de la lista
            holder.itemView.setOnClickListener {
                onProductClickedListener.onProductSelected(product)
            }
        }

        override fun getItemCount() = productList.size
}