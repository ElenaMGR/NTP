val val1:Byte = 3

Byte.MaxValue
Byte.MinValue

Short.MaxValue
Short.MinValue

Int.MaxValue
Int.MinValue

Long.MaxValue
Long.MinValue

Float.MaxValue
Float.MinValue
Float.MinPositiveValue

Double.MaxValue
Double.MinValue
Double.MinPositiveValue

// es posible la conversión de ampliación
// paso de Byte a Short
val val2:Short = val1
// no es posible la conversion de estrechamiento de forma directa
val val3:Byte = val2.toByte

// podemos declarar tipos en hexadecimal
val val4 = 0xffb325
// si ponemos una 'l' se asocia al tipo Long
val val5 = 100l


// Tipos básicos de Scala
val t = 3
t.isInstanceOf[Any]

class NumeroComplejo (val x:Double, val y:Double)
val nc = new NumeroComplejo(2.3,8.5)
nc.isInstanceOf[AnyRef]

val nada = {}

"A".hashCode

(5.0/7.0).toString

val v:Char = 65
val vEntero = v.asInstanceOf[Int]