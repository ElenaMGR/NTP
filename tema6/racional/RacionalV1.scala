package racional

class RacionalV1(n: Int, d: Int){
   override def toString = n +"/"+ d

   println("Creado "+ n +"/"+ d)
}

object RacionalV1 extends App{
   val obj1=new RacionalV1(1, 2)
   println(obj1)
}
