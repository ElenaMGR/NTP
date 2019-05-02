package racional

// Se agrega el constructor auxiliar

// Se modifica la clase anterior para crear datos miembro
class RacionalV4(n: Int, d: Int){
   val numerador:Int=n
   val denominador:Int=d

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
   def add(otro: RacionalV4): RacionalV4 =
   new RacionalV4(numerador * otro.denominador +
      otro.numerador * denominador, denominador * otro.denominador)

   // Metodo para comparar dos objetos
   def menorQue(that: RacionalV4) =
      this.numerador * that.denominador < that.numerador * this.denominador

   // Metodo para obtener el maximo de dos objetos
   def max(otro: RacionalV4) =
      if (this.menorQue(otro)) otro else this
}

object RacionalV4 extends App{
   val obj1=new RacionalV4(1, 2)
   println(obj1)
   val obj2=new RacionalV4(5, 0)
   println(obj2)
}

