package com.example.ejercicioparcial.listener

import com.example.ejercicioparcial.entidades.Producto

interface OnProductClickedListener {
        fun onProductSelected(producto: Producto)
}