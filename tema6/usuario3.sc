class Usuario(nombreUsuario:String){
   val nombre=nombreUsuario
   def prompt:String=s"$nombre>"

   override def toString:String=s"Usuario($nombre)"

   // nombreUsuario puede usarse dentro de la
   // la clase, pero no es un dato miembro
   def prueba(): Unit ={
      println("nombreUsuario: "+nombreUsuario);
   }
}

val usuario3=new Usuario("pepe")

// Sentencia no valida: nombreUsuario no es un
// dato miembro
// usuario3.nombreUsuario

println(usuario3)
println(usuario3.prompt)
