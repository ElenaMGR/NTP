package claseRacional

class RacionalV1(n:Int, d:Int) {
  override def toString = n + "/" + d
}

object Uso extends App {
  val obj1 = new RacionalV1(4,3)
  println(obj1)

  val obj2 = new RacionalV1(5,0)
  println(obj2)
}

