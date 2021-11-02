package cl.valentina.appprueba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import cl.valentina.appprueba.databinding.ActivityLibroDetalleBinding
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_libro_detalle.*

class LibroDetalle : AppCompatActivity() {

    lateinit var viewModel: LibroDetalleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLibroDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(LibroDetalleViewModel::class.java)

        inicioUI()

    }

    private fun inicioUI() {
        val id = intent.extras?.get("id") as Int

        viewModel.getDetalleLibro(id)

        viewModel.libroDetalle.observe(this, Observer { libroDetalle ->
            tituloDetalleLibro.text= libroDetalle.title
            autorDetalle.text=libroDetalle.author
            paisDetalle.text=libroDetalle.country
            paginasDetalle.text=libroDetalle.pages.toString()
            añoDetalle.text=libroDetalle.year.toString()
            lenguajeDetalle.text=libroDetalle.language
            precios.text=libroDetalle.price.toString()


            Glide.with(this).load(libroDetalle.imageLink).into(imagenDetalle)

        })
    }
}