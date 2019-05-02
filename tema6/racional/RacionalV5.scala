package racional

// Se agrega metodo maximoComunDividor y dato
// miembro privado para almacenarlo

// Se modifica la clase anterior para crear datos miembro
class RacionalV5(n: Int, d: Int){
   private val mcd = maximoComunDivisor(n.abs, d.abs)
   val numerador:Int=n/mcd
   val denominador:Int=d/mcd

   // Se introduce require para evitar creacion de 5/0
   // Se genera error de ejecucion si d == 0
   require(d != 0)

   // Constructor auxiliar: todos se llaman this y deben terminar
   // llamando al principal
   def this(n: Int) = this(n, 1)

   // Metodo toString
   override def toString = numerador +"/"+ denominador

   // Gracias a la existencia de datos miembro es posible usar
   // metodos como el de sumar
   def add(otro: RacionalV5): RacionalV5 =
   new RacionalV5(numerador * otro.denominador +
      otro.numerador * denominador, denominador * otro.denominador)

   // Metodo para comparar dos objetos
   def menorQue(that: RacionalV5) =
      this.numerador * that.denominador < that.numerador * this.denominador

   // Metodo para obtener el maximo de dos objetos
   def max(otro: RacionalV5) =
      if (this.menorQue(otro)) otro else this

   // Metodo para calcular maximo comun divisor
   private def maximoComunDivisor(a: Int, b: Int): Int = if (b == 0) a else maximoComunDivisor(b, a % b)
}

object RacionalV5 extends App{
   val obj1=new RacionalV5(66, 42)
   println(obj1)
}
