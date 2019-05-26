object BusquedaBinariaGenerica {
  def busquedaBinaria[A](coleccion : Array[A], aBuscar: A,  criterio : (A,A) => Boolean) : Int = {

    @annotation.tailrec
    def go(coleccion: Array[A], acum: Int = 0): Int = {

      val posicionMitad = coleccion.length / 2
      val valorMitad = coleccion(posicionMitad)

      if (valorMitad == aBuscar) acum + posicionMitad
      else if (coleccion.length == 1) -1
      else if (criterio(valorMitad, aBuscar)) {
        if (posicionMitad + 1 == coleccion.length) -1
        else go(coleccion.slice(posicionMitad + 1, coleccion.length), acum + posicionMitad + 1)

      }
      else if (posicionMitad == 0) -1
      else go(coleccion.slice(0, posicionMitad), acum)

    }

    if(coleccion.length == 0) -1
    else go(coleccion)
  }

  def main(args: Array[String]): Unit ={
    println("................... Busqueda binaria ...................")


    println(busquedaBinaria[Int]((1 to 30).toArray,28,_<_))

    var tiempo1TR = System.nanoTime()
    System.nanoTime()
    busquedaBinaria[Int]((1 to 10000).toArray,333, _<_)
    var tiempo2TR = System.nanoTime()
    println(" Tiempo busqueda binaria (s): "+ ((tiempo2TR-tiempo1TR)/ 1000000000.0))

    tiempo1TR = System.nanoTime()
    System.nanoTime()
    busquedaBinaria[Int]((1 to 100000000).toArray,333, _<_)
    tiempo2TR = System.nanoTime()
    println(" Tiempo busqueda saltos (s): "+ ((tiempo2TR-tiempo1TR)/ 1000000000.0))


    tiempo1TR = System.nanoTime()
    System.nanoTime()
    busquedaBinaria[Int]((1 to 100000000).toArray,45000000, _<_)
    tiempo2TR = System.nanoTime()
    println(" Tiempo busqueda saltos (s): "+ ((tiempo2TR-tiempo1TR)/ 1000000000.0))

    tiempo1TR = System.nanoTime()
    System.nanoTime()
    busquedaBinaria[Int]((1 to 100000000).toArray,95000000, _<_)
    tiempo2TR = System.nanoTime()
    println(" Tiempo busqueda saltos (s): "+ ((tiempo2TR-tiempo1TR)/ 1000000000.0))

  }
}
