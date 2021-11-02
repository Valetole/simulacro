package cl.valentina.appprueba.listaLibros

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.valentina.appprueba.R
import cl.valentina.appprueba.modelo.LibrosModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.card_lista_libros.view.*

class LibrosAdapter(val libroClick: (Int) -> Unit) :
    RecyclerView.Adapter<LibrosAdapter.ClassViewHolder>() {

    var librosLista: List<LibrosModel> = emptyList<LibrosModel>()

    fun setData(list: List<LibrosModel>) {
        librosLista = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ClassViewHolder {
        return ClassViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.card_lista_libros, parent, false)
        )

    }

    override fun getItemCount(): Int {
        return librosLista.size
    }

    override fun onBindViewHolder(holder: ClassViewHolder, position: Int) {
        val libro = librosLista[position]
        holder.itemView.tvTituloLibro.text = libro.title
        holder.itemView.tvAutorLibro.text = libro.author
        holder.bind(libro)
        holder.itemView.setOnClickListener {libroClick(position + 1)} // revisar
    }

    class ClassViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val imagen = itemview.imagenLibro

        fun bind(data: LibrosModel) {
            Glide.with(imagen).load(data.imageLink).into(imagen)
        }
    }
}



