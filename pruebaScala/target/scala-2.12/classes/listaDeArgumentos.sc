// funcion que recibe lista de argumentos varialbe

def sumar(numeros:Int *) = {
  var total = 0
  for (i <- numeros) total+=i
  total
}

sumar(0,1,2,3,4)
sumar(1,2,3,4,5,6,7,8,9)

// funciones con varias listas de argumentos
// currying
def multiplicar (x : Int)(y : Int)(z : Int) = x*y*z


val multiplicar3 :Int => Int => Int = multiplicar(3)
val multiplicar34 = multiplicar3(4)
val resultado = multiplicar34(8)

def max(x:Int)(y:Int) = if (x>y) x else y

val f = max _

val f1 = max(3) _

val f2 = max(_:Int)(3)