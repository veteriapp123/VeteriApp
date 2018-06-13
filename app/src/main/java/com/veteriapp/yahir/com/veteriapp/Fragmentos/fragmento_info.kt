package com.veteriapp.yahir.com.veteriapp.Fragmentos


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase


import com.veteriapp.yahir.com.veteriapp.R
import kotlinx.android.synthetic.main.fragment_fragmento_info.*
import java.util.jar.Attributes


open class fragmento_info : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(container?.context).inflate(R.layout.fragment_fragmento_info,container,false)

        btnAgregarArticulo.setOnClickListener {
            ArticuloEnviar()
        }

    }

    fun ArticuloEnviar(){
        val nombre = txtNombreArticulo?.text.toString()
        val articulo = txtDescripcionArticulo?.text.toString()

        if (nombre != "" && articulo != "")
        {
            val db = FirebaseDatabase.getInstance().reference.child("Articulos")
            db.push().setValue(nombre,articulo)
            Toast.makeText(context,"Agregado", Toast.LENGTH_SHORT).show()


        }
        else{
            Toast.makeText(context,"Escribir Todos Los Campos", Toast.LENGTH_SHORT).show()
        }
    }

}