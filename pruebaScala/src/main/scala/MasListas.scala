object MasListas extends App{
  val lista1 = List(1,2,3)
  val lista2 = List(1,2,3)

  // igualdad de Listas
  println("igualdad con eq: "+ (lista1 eq lista2))
  println("igualdad con ==: "+ (lista1 == lista2))

  // igualdad de listas vacías
  val aNil:List[String] = Nil
  val bNil:List[Double] = Nil
  println("aNil eq bNil: " +(aNil eq bNil))
  println("aNil == bNil: " +(aNil == bNil))

  // uso de head y tail
  val head = lista1.head
  val tail = lista1.tail
  println("Cabeza: "+head+" Cola: "+tail)

  // acceso con paréntesis
  val primero = lista1(0)
  println ("primero: "+primero)

  // tratamiento de excepciones
  try{
    println(lista1(5))
  }catch {
    case e: IndexOutOfBoundsException => println("indice fuera de rango")
    case _ => println("otra excepcion")
  }

  // listas inmutables: las operaciones generan nuevos objetos
  val lista3 = List(1,3,5,7,9)
  val lista4 = lista3.filterNot(v => v == 5)
  println("lista3: "+lista3)
  println("lista4: "+lista4)

  // uso de map
  //val lista3por2 = lista3 map {_*2}  es equivalente a {v => v*2}
  val lista3por2 = lista3 map {v => v*2}
  println ("lista3por2: "+lista3por2)

  // filtrado normal
  val divisible3 = lista3 filter (x => x%3 == 0)

  // reducción de colecciones
  val suma = lista3 reduceLeft(_ + _)
  val suma2 = lista3.reduceLeft((el1,el2) => {
    println("el1: "+el1+" el2: "+el2)
    (el1+el2)
  })
  val suma3 = lista3.reduceRight((el1,el2) => {
    println("el1: "+el1+" el2: "+el2)
    (el1+el2)
  })

  // versiones con foldLeft
  val suma4 = lista3.foldLeft(0){_ + _}

  val multiplicacion = lista3.foldLeft(1){_ * _}

  //generar listas a partir de rangos
  val listaRango = (0 to 100).toList
  println(listaRango)

  // operaciones de agregación
  // elemento al principio
  val lista5 = 0::lista3
  println(lista5)

  //agregar dos listas
  val lista6 = (lista1:::lista2).sorted
  println(lista6)

  // ----------------------- TUPLAS ----------------------------------------
  val tupla1 = (1, "lunes", 2.8, 'c', false)
  println("elemento de la tupla: "+tupla1._3)

  // inversión de elementos
  val tupla2 = (1, "lista")
  val tupla3 = tupla2.swap //swap solo se puede utilizar cuando son dos elementos
  println("tupla3: "+tupla3)


}


// Crear main
/*object Ejecutable {
  def main(args : Array[String] ) : Unit ={

  }
}*/
