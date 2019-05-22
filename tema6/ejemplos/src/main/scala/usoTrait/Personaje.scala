package UsoTrait

class Personaje (val nombre:String) {
  def sufijo = ""

  override def toString = s"$nombre$sufijo"
}

trait Elfo{self : Personaje =>
  override def sufijo="-(elfo)"
}

trait Mago{self : Personaje =>
  override def sufijo="-(mago)"
}

trait Aprendiz{self : Personaje =>
  override def sufijo="-(aprendiz)"
}

// stackable traits
object EjemploUso extends App{
  val obj1 = new Personaje(nombre = "Harry Potter") with Mago with Aprendiz
  val obj2 = new Personaje (nombre = "Dobby") with Elfo
  println(obj1)
  println(obj2)
}
