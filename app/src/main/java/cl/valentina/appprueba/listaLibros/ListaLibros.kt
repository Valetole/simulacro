package cl.valentina.appprueba.listaLibros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import cl.valentina.appprueba.LibroDetalle
import cl.valentina.appprueba.databinding.ActivityListaLibrosBinding
import kotlinx.android.synthetic.main.activity_lista_libros.*

class ListaLibros : AppCompatActivity() {

    private lateinit var viewModel: LibrosViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityListaLibrosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(LibrosViewModel::class.java)

        inicioUI()
    }

    private fun inicioUI() {
        recyclerViewLibros.layoutManager = LinearLayoutManager(this)
        recyclerViewLibros.adapter = LibrosAdapter {
            val intent = Intent(this, LibroDetalle::class.java)
            intent.putExtra("id", it)
            startActivity(intent)
        }
        viewModel.getLibrosLista()

        viewModel.librosLista.observe(this, Observer { list ->
            (recyclerViewLibros.adapter as LibrosAdapter).setData(list)

        })

    }
}