package com.example.ejercicioparcial.fragmentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.ejercicioparcial.R


class Detalle : Fragment() {

    private lateinit var description: TextView
    private lateinit var price: TextView
    private lateinit var productImage: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        description = view.findViewById(R.id.product_description)
        price = view.findViewById(R.id.product_price)
        productImage = view.findViewById(R.id.product_image)

        arguments?.let {
            val product = DetalleArgs.fromBundle(it).producto

            description.text = product.description
            price.text = "$${product.price}"
            Glide.with(this)
                .load(product.imageLink)
                .into(productImage)
        }

    }

}