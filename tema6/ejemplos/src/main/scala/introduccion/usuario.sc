class Usuario

val usuario1=new Usuario

val esAnyRef=usuario1.isInstanceOf[AnyRef]
val esAny=usuario1.isInstanceOf[Any]

class Usuario2{
  val nombre:String="administrdor"
  def prompt:String=nombre+">"

  override def toString: String = s"Usuario($nombre)"
}

val usuario2=new Usuario2