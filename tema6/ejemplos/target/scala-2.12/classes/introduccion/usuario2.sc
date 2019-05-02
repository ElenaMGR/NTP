// se agrega parametro de clase
class Usuario(nombreUsuario : String){
  val nombre=nombreUsuario
  def prompt:String=nombre+">"

  override def toString:String=s"Usuario($nombre)"
}

val usuario3=new Usuario("Pepe")

// no se puede acceder a nombreUsuario
//usuario3.nombreUsuario

