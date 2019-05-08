val d = new java.util.Date

//Importacion completa
import java.util.Date

import scala.collection.mutable

val d1 = new Date

// Importacion parcial
import java.util
val d2 = new util.Date

// Importacion de todas las clases de un paquete
import collection.mutable._

val obj1 = new ArrayBuffer[String]
obj1+="Hola"
obj1+="Adios"
println(obj1)

// Importacion selectiva usando llaves
import collection.mutable.{Queue, ArrayBuffer}

// Definicion de alias para clases importadas
import collection.immutable.{Map => MapaInmutable}
val mapa = MapaInmutable(2->3, 4->5)
println(mapa)

// Excluir algunas clases del import
import java.util.{Random => _, _}
// Por lo tanto la siguiente línea da error
//val generador = new Random
val arrayList = new util.ArrayList