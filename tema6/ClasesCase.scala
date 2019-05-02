
case class Personaje(nombre:String, heroe:Boolean)

object ClasesCase extends App{

   // Como se dispone del metodo apply la construccion puede
   // hacerse sin new
   val personaje1=Personaje("Gollum", false)
   val personaje2=Personaje("Gandalf", true)

   // Puede usarse directamente ==
   val comparacion:Boolean =  personaje1 == personaje2
   println(comparacion)

   // Se utiliza el metodo toString
   println(personaje1)

   // se usa copy: se cambia el dato miembro nombre
   val personaje3=personaje1.copy("Sauron")
   println(personaje3)

   // se usa unapply
   val resultado=Personaje.unapply(personaje1)
   println(resultado)
}
