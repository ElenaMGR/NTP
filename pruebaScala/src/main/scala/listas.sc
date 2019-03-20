// creacion de listas
val lista1 = List(1,2,3)
val lista2 = List(4,5,6)

// concatenacion
val r1 = lista1 ::: lista2

// obtener longitud de la lista
r1.length

// agregar elemento
var r2 = 0 :: lista1
println(lista1)

// contar
r1.count(x => x%2 == 0)

// eliminar
r1.drop(1)
r1.dropRight(3)
r1.exists(x => x > 10)


// devolver el primer elemento de la lista
val primero = lista1.head
// devolver el resto de elementos de la lista (menos el primero)
val resto = lista1.tail

lista1 match{
  case head::tail => head
  case Nil => println("vacia")
}