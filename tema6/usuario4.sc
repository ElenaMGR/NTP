class Usuario(val nombre:String){
   def prompt:String=s"$nombre>"

   override def toString: String = s"Usuario($nombre)"
}

val usuarios=List(new Usuario("administrador"),
                  new Usuario("usuario"),
                  new Usuario("operador"))

val longitudes = usuarios map (_.nombre.size)
val ordenados = usuarios sortBy(_.nombre)
val conD = usuarios filter (_.nombre contains "d")
val promptConD = conD map (_.prompt)




