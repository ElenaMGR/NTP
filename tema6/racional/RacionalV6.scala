package racional

// Se agregan operadores + y *

// Se modifica la clase anterior para crear datos miembro
class RacionalV6(n: Int, d: Int){
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

   // Operador de suma
   def + (that: RacionalV6): RacionalV6 =
      new RacionalV6(numerador * that.denominador + that.numerador * denominador,
                     denominador * that.denominador)

   // Otra version de +
   def + (i: Int): RacionalV6 =
      new RacionalV6(numerador + i * denominador, denominador)

   // Metodo de resta
   def - (that: RacionalV6): RacionalV6 =
      new RacionalV6(numerador * that.denominador - that.numerador * denominador,
                     denominador * that.denominador)

   // Otra version de resta
   def - (i: Int): RacionalV6 = new RacionalV6(numerador - i * denominador, denominador)

   // Operador de multiplicacion
   def * (that: RacionalV6): RacionalV6 =
      new RacionalV6(numerador * that.numerador, denominador * that.denominador)

   // Otra version de multiplicacion
   def * (i: Int): RacionalV6 = new RacionalV6(numerador * i, denominador)

   // Operacion de division
   def / (that: RacionalV6): RacionalV6 = new RacionalV6(numerador * that.denominador,
                                                         denominador * that.denominador)

   // Otra version de division
   def / (i: Int): RacionalV6 = new RacionalV6(denominador, denominador * i)

   // Metodo para comparar dos objetos
   def menorQue(that: RacionalV6) =
      this.numerador * that.denominador < that.numerador * this.denominador

   // Metodo para obtener el maximo de dos objetos
   def max(otro: RacionalV6) =
      if (this.menorQue(otro)) otro else this

   // Metodo para calcular maximo comun divisor
   private def maximoComunDivisor(a: Int, b: Int): Int =
      if (b == 0) a else maximoComunDivisor(b, a % b)
}

object RacionalV6 extends App{
   val obj1=new RacionalV6(66, 42)
   println(obj1)
   val obj2 = new RacionalV6(2, 3)
   println(obj2)
   val obj3=obj1+obj2
   println("Suma: "+obj3)
   val obj4=obj1*obj2
   println("Producto: "+obj4)
}

