package com.example.tarea01guarga_links

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.tarea01guarga_links.databinding.ActivityMainBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

//Main

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FirebaseApp.initializeApp(this)
        auth = Firebase.auth

        //Metodo para login
        binding.btLogin.setOnClickListener {
            haceLogin();
        }
        binding.btRegister.setOnClickListener {
            haceRegister();
        }

    }

    private fun haceRegister() {
        val email = binding.etEmail.text.toString()
        val clave = binding.etClave.text.toString()

        auth.createUserWithEmailAndPassword(email,clave).
                addOnCompleteListener(this){task ->
                    if(task.isSuccessful){
                        Log.d("creado usuario", "Registrado")
                        val user = auth.currentUser
                        actualizar(user);
                    }else{
                        Log.d("creado usuario", "Fallo")
                        Toast.makeText(baseContext,"Fallo",Toast.LENGTH_LONG).show()
                        actualizar(null);
                    }
                }
    }

    private fun actualizar(user: FirebaseUser?) {
        if(user != null){
            val intent = Intent(this, Principal::class.java)
            startActivity(intent)
        }else{

        }
    }

    public override fun onStart(){
        super.onStart()
        val user = auth.currentUser
        actualizar(user)
    }

    private fun haceLogin() {
        val email = binding.etEmail.text.toString()
        val clave = binding.etClave.text.toString()

        auth.signInWithEmailAndPassword(email,clave).
        addOnCompleteListener(this){task ->
            if(task.isSuccessful){
                Log.d("Autenticado", "Autenticado")
                val user = auth.currentUser
                actualizar(user);
            }else{
                Log.d("Autenticado", "Fallo")
                Toast.makeText(baseContext,"Fallo",Toast.LENGTH_LONG).show()
                actualizar(null);
            }
        }
    }
}