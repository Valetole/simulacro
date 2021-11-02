package cl.valentina.appprueba.listaLibros

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cl.valentina.appprueba.api.LibroApi
import cl.valentina.appprueba.modelo.LibrosModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LibrosViewModel : ViewModel() {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://my-json-server.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service: LibroApi = retrofit.create(LibroApi::class.java)

    val librosLista = MutableLiveData<List<LibrosModel>>()

    fun getLibrosLista() {
        val call = service.getListLibros()

        call.enqueue(object : Callback<List<LibrosModel>> {
            override fun onResponse(
                call: Call<List<LibrosModel>>,
                response: Response<List<LibrosModel>>
            ) {
                response.body()?.let { list ->
                    librosLista.postValue(list)
                }
            }

            override fun onFailure(call: Call<List<LibrosModel>>, t: Throwable) {
                call.cancel()
            }
        })
    }
}