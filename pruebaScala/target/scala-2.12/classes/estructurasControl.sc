// bucle imperativo
var i=10

while(i > 0){
  println("Valor i: "+i)
  i=i-1
}

// do-while imperativo
i = 10
do{
  println("Valor de i: "+i)
  i=i-1
}while(i>=0)

// estilo funcional
// for coprehension
for (i <- 1 to 10){
  println("valor de i: "+i)
}

val rango1 = 1 to 10
val rango2 = 1 until 10 //no llega hasta el 10, se queda en el 9
val rango3 = 1 to 10 by 2
val rango4 = 10 to 1 by -2

// for con devulucion de valores
for (i <- rango2) yield i

val resultado = for (i <- rango4) yield i

val cadenas = for (i <- 1 to 10) yield{
  println("iteracion con i: "+i)
  s"Valor de i: $i "
}

//for anidado
val resultado2 = for{i <- 1 to 3
                      j <- 1 to 5} yield i+j

val resultado3 = for (i <- 1 to 3;
                      j <- 1 to 5) yield (i,j)