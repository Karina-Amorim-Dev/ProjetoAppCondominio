package com.example.appcondominio

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AutorizacaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_autorizacao)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btnSalvar)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSalvar = findViewById<Button>(R.id.btnSalvar)
        btnSalvar.setOnClickListener {

            val nome = findViewById<EditText>(R.id.TextNome).text.toString().trim()
            val documento = findViewById<EditText>(R.id.TextDocumento).text.toString().trim()
            val apartamento = findViewById<EditText>(R.id.TextApartamento).text.toString().trim()

            if (nome.isEmpty() || documento.isEmpty() || apartamento.isEmpty()) {

                Toast.makeText(
                    this,
                    "Todos os campos são obrigatórios",
                    Toast.LENGTH_LONG
                ).show()

            } else {

                Toast.makeText(
                    this,
                    "Autorização realizada com sucesso",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        val toolBarAutorizacao = findViewById<Toolbar>(R.id.toolbarAutorizacao)
        setSupportActionBar(toolBarAutorizacao)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }

    }
}