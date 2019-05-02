
object ConexionBaseDatos{
   private val url="jdbc://localhost"
   private val usuario="admin"
   private val password="1234"
   def apply() = new ConexionBaseDatos
}

class ConexionBaseDatos{
   private val propiedades=Map(
      "url" -> ConexionBaseDatos.url,
      "usuario" -> ConexionBaseDatos.usuario,
      "password" -> ConexionBaseDatos.password
   )
   println("Creado nuevo objeto: "+propiedades("url"))
}

object ejemploObjeto4 extends App{
   val conexion=ConexionBaseDatos()
}
