package racional

// Se modifica la clase anterior para crear datos miembro
class RacionalV3(n: Int, d: Int){
   val numerador:Int=n
   val denominador:Int=d

   // Se introduce require para evitar creacion de 5/0
   // Se genera error de ejecucion si d == 0
   require(d != 0)
   override def toString = numerador +"/"+ denominador

   // Gracias a la existencia de datos miembro es posible usar
   // metodos como el de sumar
   def add(otro: RacionalV3): RacionalV3 =
            new RacionalV3(numerador * otro.denominador +
                           otro.numerador * denominador, denominador * otro.denominador)

   // Metodo para comparar dos objetos
   def menorQue(that: RacionalV3) =
      this.numerador * that.denominador < that.numerador * this.denominador

   // Metodo para obtener el maximo de dos objetos
   def max(otro: RacionalV3) =
      if (this.menorQue(otro)) otro else this
}

object RacionalV3 extends App{
   val obj1=new RacionalV3(1, 2)
   println(obj1)
   val obj2=new RacionalV3(5, 0)
   println(obj2)
}
