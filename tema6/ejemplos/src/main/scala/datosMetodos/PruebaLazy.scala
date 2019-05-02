package datosMetodos

class PuntoAleatorio{
  val x = {
    println("Asignacion de x")
    util.Random.nextInt
  }

  lazy val y = {
    println("Aasignacion de y")
    util.Random.nextInt
  }
}

object PruebaLazy extends App {
  val p1 = new PuntoAleatorio
  println("finaliza construccion del objeto p1")
  println("valor de componente y: "+p1.y)
}
