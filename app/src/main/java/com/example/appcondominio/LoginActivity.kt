package com.example.appcondominio

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.txtrecyclerView)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val intentHome = Intent(this, HomeActivity::class.java)
        val intentCadastro = Intent(this, CadastroActivity::class.java)

        val buttonLogin = findViewById<Button>(R.id.btnLogin)
        val cadastro = findViewById<Button>(R.id.btnCadastro)

        buttonLogin.setOnClickListener {
            val email = findViewById<EditText>(R.id.txtEmail).text.toString()
            val senha = findViewById<EditText>(R.id.txtSenhaLogin).text.toString()

            if (email.equals("ka.amorim@hotmail.com") && senha.equals("12345")) {
                intentHome.putExtra("nome", "Karina Amorim")
                startActivity(intentHome)
                Toast.makeText(this, "Logado", Toast.LENGTH_LONG).show()
            }else {
                Toast.makeText(this, "Login não encontrado", Toast.LENGTH_LONG).show()
            }
        }
        cadastro.setOnClickListener {
            startActivity(intentCadastro)
        }
    }
}