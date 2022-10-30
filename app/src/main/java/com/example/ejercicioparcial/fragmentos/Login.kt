package com.example.ejercicioparcial.fragmentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.ejercicioparcial.R


class Login : Fragment() {

    lateinit var vista: View
    lateinit var boton: Button
    lateinit var email: EditText
    lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_login, container, false)
        boton = vista.findViewById(R.id.boton1)
        return vista
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()
        val continueButton = view.findViewById<Button>(R.id.boton1)
        email = view.findViewById(R.id.email)
        password = view.findViewById(R.id.password)

        // Establezco un listener para escuchar cualquier click en el boton
        continueButton.setOnClickListener {

            // Navego hacia la home
            navController.navigate(
                LoginDirections.actionLoginToLista2(
                    email.text.toString(),
                    password.text.toString()
                )
            )
        }
    }

    /*override fun onStart() {
        super.onStart()
        boton.setOnClickListener{

            val action = LoginDirections.actionLoginToLista2()

            vista.findNavController().navigate(action)
        }
    }*/
}