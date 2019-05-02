class Usuario(private var password:String){
   def actualizarPassword(p:String): Unit ={
      password=p
   }

   def validar(p:String) = p == password
}

val usuario1=new Usuario("1234")
val esValido=usuario1.validar("4567")
usuario1.actualizarPassword("4567")
val esValido2=usuario1.validar("4567")
