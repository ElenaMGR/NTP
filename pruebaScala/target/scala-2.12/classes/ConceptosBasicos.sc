// Valores
val x = 5

// Variables
var y = 3.8

// To_do es un objeto
3.getClass.getName
8.3.getClass.getName
'c'.getClass.getName
"Hola, Pepe".getClass.getName
true.getClass.getName

// Declaración de funcioón
val f = (x:Int,y:Int) => x+5
((x:Int , y:Int) => 5).getClass.getName

y=5

val c='c'

val array: Array[Int] = new Array(10)
array(1)=8

array.foreach(println)

// declaración de clases
class NumeroComplejo(val x:Double, val y:Double){
  println("Creado objeto clase NumeroComplejo")

  override def toString: String = {
    "x : "+x+", y : "+y
  }
}

val nc1 = new NumeroComplejo(7.2, 8.3)

println("dato miembro x: "+nc1.x)

// Si no se pone var o val no son datos miembro, son argumentos del constructor
class NumeroComplejo2 (x:Double, y:Double){
  println("argumento x: "+x)
}

val nc2 = new NumeroComplejo2(3.3,4.4)
// no se puede acceder al argumento con nc2.x

