class Usuario(val nombre:String){
  def prompt:String=nombre+">"

  override def toString=s"Usuario($nombre)"
}

val usuario=new Usuario("administrador")
usuario.nombre

val usuarios=List(new Usuario("administrador"),
  new Usuario("operador"),
  new Usuario("gestorBD"))

val longitudes = usuarios map (_.nombre.size)
val conD = usuarios.filter(_.nombre.contains("d"))