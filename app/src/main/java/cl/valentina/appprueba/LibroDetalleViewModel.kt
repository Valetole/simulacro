package cl.valentina.appprueba

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cl.valentina.appprueba.api.LibroApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LibroDetalleViewModel: ViewModel () {

    private val retrofit = Retrofit.Builder()
    .baseUrl("https://my-json-server.typicode.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

    private val service: LibroApi = retrofit.create(LibroApi::class.java)

    val libroDetalle = MutableLiveData<DetalleLibroModel>()

    fun getDetalleLibro(id: Int) {
        val call = service.getDetalleLibro(id)

        call.enqueue(object : Callback<DetalleLibroModel> {
            override fun onResponse(
                call: Call<DetalleLibroModel>,
                response: Response<DetalleLibroModel>
            ) {
                response.body()?.let { detalle ->
                    libroDetalle.postValue(detalle)
                }
            }

            override fun onFailure(call: Call<DetalleLibroModel>, t: Throwable) {
                call.cancel()
            }
        } )
    }
}