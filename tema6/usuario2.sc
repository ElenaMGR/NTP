class Usuario{
   val nombre:String="administrador"
   def prompt:String=s"$nombre>"
   override def toString=s"Usuario($nombre)"
}

val usuario2=new Usuario
println(usuario2)

println(usuario2.prompt)




