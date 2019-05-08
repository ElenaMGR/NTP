package claseCase

// datos miembro son val
case class Personaje(nombre:String, heroe:Boolean)

object ClaseCase extends App{
  val obj1 = new Personaje("Gollum", false)
  val obj2 = Personaje("Gandalf",true)
  val obj3 = Personaje("Gandalf", true)

  // no pueden modificarse los datos miembro
  //obj1.heroe=true

  val comparacion = (obj1 == obj2)
  println("comparacion: " + comparacion)
  val comparacion2 = (obj3 == obj2)
  println("comparacion: " + comparacion2)
  println(obj3)

  val obj4 = obj1.copy("Saurom")
  println(obj4)

  val res = Personaje.unapply(obj4)
  println(res)
}