package claseRacional

import scala.annotation.tailrec

class RacionalV3(n:Int, d:Int) {
  // controla que d sea distinto de cero para proceder
  require(d != 0)

  // calcuclar el mcd
  val mcd = RacionalV3.mcd(n,d)

  // constructor adicional: se llaman this y tienen que terinar llamando al principal (this, con el nuero de argumentos
  // que aparecen en la clase)
  def this(n:Int) = this(n,1)

  // almacenar n y d como datos miembro
  val numerador = n/mcd
  val denominador = d/mcd

  // metodo para sumar dos racionales
  def +(otro:RacionalV3) : RacionalV3 = {
    new RacionalV3(numerador*otro.denominador+otro.numerador*denominador, denominador*otro.denominador)
  }

  def +(numero:Int) : RacionalV3 = {
    this + new RacionalV3(numero)
  }

  def +::(numero:Int) : RacionalV3 = this + RacionalV3(numero)

  def < (otro:RacionalV3) : Boolean = {
    numerador*otro.denominador < otro.numerador*denominador
  }

  def == (otro:RacionalV3) : Boolean = {
    !this.<(otro) && !otro.<(this)
  }

  def max (otro:RacionalV3) : RacionalV3 = {
    if (this.<(otro)) otro
    else this
  }

  override def toString = numerador + "/" + denominador
}

object RacionalV3 extends App {
  def apply (n:Int , d:Int) = new RacionalV3(n,d)
  def apply (n:Int) = new RacionalV3(n)
  @tailrec
  def mcd(a:Int, b:Int) : Int = {
    if (b == 0) a
    else mcd(b, a%b)
  }


  val obj1 = new RacionalV3(2,3)
  println(obj1)

  val obj2 = new RacionalV3(4,5)
  val obj22 = new RacionalV3(4,5)
  println(obj2)
  val suma = obj1 + obj2
  println(suma)

  println("4/5 < 2/3: " + (obj2 < obj1) )
  println("4/5 igual que 4/5: " + (obj2 == obj22))
  println("maximo de 4/5 y 2/3: "+obj2.max(obj1))

  val obj3 = new RacionalV3(5)
  println(obj3)

  val obj4 = new RacionalV3(25,125)
  println(obj4)

  println("4/5 + 20: " + (obj2 + 20) )
}
