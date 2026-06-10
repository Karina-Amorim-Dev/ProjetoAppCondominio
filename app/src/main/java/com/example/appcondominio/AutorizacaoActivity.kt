package com.example.appcondominio

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.DatePicker
import androidx.appcompat.widget.Toolbar
import android.view.MenuItem


class AutorizacaoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_autorizacao)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.layoutAutorizacao)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolBarAutorizacao = findViewById<Toolbar>(R.id.toolbarAutorizacao)
        setSupportActionBar(toolBarAutorizacao)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val txtNome = findViewById<EditText>(R.id.TextNome)
        val txtDocumento = findViewById<EditText>(R.id.TextDocumento)
        val txtApartamento = findViewById<EditText>(R.id.TextApartamento)
        val txtMensagem = findViewById<TextView>(R.id.txtMensagem)

        val btnSalvar = findViewById<Button>(R.id.btnSalvar)

        btnSalvar.setOnClickListener {

            val nome = txtNome.text.toString().trim()
            val documento = txtDocumento.text.toString().trim()
            val apartamento = txtApartamento.text.toString().trim()

            val datePicker = findViewById<DatePicker>(R.id.datepickerAutorizacao)

            if (nome.isEmpty() || documento.isEmpty() || apartamento.isEmpty()) {

                txtMensagem.text = "Todos os campos são obrigatórios"
                txtMensagem.setTextColor(Color.parseColor("#D32F2F"))
                txtMensagem.visibility = View.VISIBLE

            } else {

                txtMensagem.text = "Autorização cadastrada com sucesso!"
                txtMensagem.setTextColor(Color.parseColor("#2E7D32"))
                txtMensagem.visibility = View.VISIBLE

                // Limpa os campos
                txtNome.text.clear()
                txtDocumento.text.clear()
                txtApartamento.text.clear()

                // Volta a data para hoje
                val calendario = java.util.Calendar.getInstance()

                datePicker.updateDate(
                    calendario.get(java.util.Calendar.YEAR),
                    calendario.get(java.util.Calendar.MONTH),
                    calendario.get(java.util.Calendar.DAY_OF_MONTH)
                )
            }

            Handler(Looper.getMainLooper()).postDelayed({
                txtMensagem.visibility = View.GONE
            }, 2000)


        }
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