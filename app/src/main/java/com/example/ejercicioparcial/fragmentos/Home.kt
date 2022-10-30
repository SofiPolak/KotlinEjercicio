package com.example.ejercicioparcial.fragmentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ejercicioparcial.R
import com.example.ejercicioparcial.UserSession
import com.example.ejercicioparcial.adapter.ProductoListAdapter
import com.example.ejercicioparcial.entidades.Producto
import com.example.ejercicioparcial.listener.OnProductClickedListener
import com.example.ejercicioparcial.utils.Images

class Home : Fragment(), OnProductClickedListener {

    private lateinit var saludo: TextView
    private lateinit var recProductos : RecyclerView
    private lateinit var productos: List<Producto>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lista, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recProductos = view.findViewById(R.id.rec_productos)
        saludo = view.findViewById(R.id.saludo)

        // Pongo el nombre del usuario en el titulo.
        // Advertencia: Al momento de mostrar un texto al usuario siempre usar un String resource. Nunca hardcodear de
        // esta manera.
        saludo.text = "Hola, ${UserSession.userName}"
        fillProductList()
    }

    /**
     * Cargo los productos que voy a usar para mostrar en la lista de la home
     */
    private fun fillProductList() {
        val product1 = Producto("Google Pixel 5", Images.pixel, 70000.0)
        val product2 = Producto("Remera estampada", Images.remera, 1500.0)
        val product3 = Producto("Zapatillas nike", Images.zapatillas, 25000.0)
        val product4 = Producto("Heladera no frost", Images.heladera, 80000.0)
        val product5 = Producto("PC Gamer", Images.pcGamer, 150000.0)
        val product6 = Producto("Campera invierno", Images.camperaInvierno, 30000.0)

        // Lleno una lista con productos que cree a mano
        productos = listOf(product1, product2, product3, product4, product5, product6)

        // Configuro el recyclerview y le paso un Adapter
        val layoutManager = LinearLayoutManager(context)
        recProductos.layoutManager = layoutManager
        recProductos.adapter = ProductoListAdapter(productos, this)
    }

    /**
     * Como esta clase implementa OnProductClickedListener, entonces tengo que implementar este metodo, donde voy
     * a navegar hacia el fragemnt de detalle de producto pasando como argumento el producto que seleccione
     * @param product Producto seleccionado de la lista
     */
    override fun onProductSelected(product: Producto) {
        findNavController().navigate(HomeDirections.actionListaToDetalle(product))
    }
}