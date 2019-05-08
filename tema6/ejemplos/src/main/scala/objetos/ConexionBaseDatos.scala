package objetos

// companion object
object ConexionBaseDatos {
  private val url = "jdbc:://localhost"
  private val usuario = "admin"
  private val password = "1234"

  def apply = new ConexionBaseDatos
}

class ConexionBaseDatos {
  private val propiedades = Map (
      "url" -> ConexionBaseDatos.url,
      "usuario" -> ConexionBaseDatos.usuario,
      "password" -> ConexionBaseDatos.password
  )
}

class A1 {
  val a:Int = 3
  val b:Int = 4

  def sumar = a+b

}

object ObjetoHeredaA extends A1

class Prueba extends App {
  val conexion = ConexionBaseDatos

  val resultado = ObjetoHeredaA.sumar
}