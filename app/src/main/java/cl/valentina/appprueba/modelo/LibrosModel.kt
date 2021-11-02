package cl.valentina.appprueba.modelo

data class LibrosModel(
    val id: Int,
    val author: String,
    val country: String,
    val imageLink: String,
    val language: String,
    val title: String
)