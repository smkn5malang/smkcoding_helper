package com.wellyimmanuel.helper

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnRegister.setOnClickListener {
            val email = inputEmailRegister.text.toString()
            val password = inputPasswordRegister.text.toString()

            Log.d("Register", "Email is" + email)
            Log.d("Register", "Password:$password")

            if (email.isEmpty()|| password.isEmpty()) {
                Toast.makeText(this, "Masukkan Email dan Password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val progressDialog = ProgressDialog(this,
                R.style.Theme_MaterialComponents_Light_Dialog)
            progressDialog.isIndeterminate = true
            progressDialog.setMessage("Mengautentikasi...")
            progressDialog.show()

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener{
                    if (!it.isSuccessful){ return@addOnCompleteListener
                        val intent = Intent (this, Register::class.java)
                        startActivity(intent)
                    }
                    else
                        Log.d("Main", "Succesfully created user with uid: ${it.result.user.uid}")
                    Toast.makeText(this, "Sukses membuat akun", Toast.LENGTH_SHORT).show()
                    val intent = Intent (this, Login::class.java)
                    startActivity(intent)
                    finish()
                }
                .addOnFailureListener{
                    Log.d("Main", "Gagal membuat akun: ${it.message}")
                    Toast.makeText(this, "Email/Password tidak benar", Toast.LENGTH_SHORT).show()
                }
        }

    }
}
