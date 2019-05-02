package racional


class RacionalV2(n: Int, d: Int){
   // Se introduce require para evitar creacion de 5/0
   // Se genera error de ejecucion si d == 0
   require(d != 0)
   override def toString = n +"/"+ d

   println("Creado "+ n +"/"+ d)
}

object RacionalV2 extends App{
   val obj1=new RacionalV2(1, 2)
   println(obj1)
   val obj2=new RacionalV2(5, 0)
   println(obj2)
}

