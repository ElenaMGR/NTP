package controlAcceso

private [controlAcceso] class Configuracion {
  val url = "http://localhots"
}

class Autenticacion{
  // Dato miembro privado para cada instancia
  private [this] val password="1234"

  def comparar (otro : Autenticacion) : Boolean = {
    //password == otro.password
    false
  }
}

class Usuario(private var password:String){
  def actualizarPassword(pwd:String) = password = pwd
  def validar(pwd:String)=password==pwd
}

object Prueba extends App {
  val usuario= new Usuario("1234")
  // No se puede acceder porque hemos dicho que password es privada
  //println("pwd de usuario: "+usuario.password)
}