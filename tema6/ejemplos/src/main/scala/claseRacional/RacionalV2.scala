package claseRacional

class RacionalV2(n:Int, d:Int) {
  // controla que d sea distinto de cero para proceder
  require(d != 0)
  override def toString = n + "/" + d
}

object Uso2 extends App {
  val obj1 = new RacionalV2(4,3)
  println(obj1)

  val obj2 = new RacionalV2(5,0)
  println(obj2)
}
