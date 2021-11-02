package cl.valentina.appprueba.api

import cl.valentina.appprueba.DetalleLibroModel
import cl.valentina.appprueba.modelo.LibrosModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface LibroApi {

    @GET("Himuravidal/anchorBooks/books")
    fun getListLibros(): Call<List<LibrosModel>>

    @GET("Himuravidal/anchorBooks/bookDetail/{id}")
    fun getDetalleLibro(@Path("id") id: Int): Call<DetalleLibroModel>
}