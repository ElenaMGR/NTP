import scala.math.{sqrt,floor}
object BusquedaSaltosGenerica {
  def busquedaSaltos[A](coleccion : Array[A], aBuscar: A,  criterio : (A,A) => Boolean) : Int = {

    val tamañoBloque = floor(sqrt(coleccion.length)).toInt

    def busqueda(subColeccion: Array[A], acum: Int = 1): Int = {
      var posicion = (tamañoBloque)*acum
      if(posicion>coleccion.length) posicion = (coleccion.length)
      val valor = coleccion(posicion-1)
      if (aBuscar == valor) posicion-1
      else  if (subColeccion.length==0) -1
      else if (criterio(aBuscar,valor)){
        var pos = -1
        for (i <- (posicion-tamañoBloque) to (posicion-1)){
          if (coleccion(i)==aBuscar) pos = i
        }
        pos
      }
      else{

        var ultimo = posicion+tamañoBloque+1
        if (ultimo>coleccion.length) ultimo = coleccion.length
        busqueda(coleccion.slice((posicion+1),ultimo),acum+1)
      }
    }

    busqueda(coleccion)
  }

  def main(args: Array[String]): Unit ={
    println("................... Busqueda binaria ...................")

    for (i <- (-3 to 12))
      println(busquedaSaltos[Int]((1 to 11).toArray,i, _<_))

    var tiempo1TR = System.nanoTime()
    System.nanoTime()
    busquedaSaltos[Int]((1 to 10000).toArray,333, _<_)
    var tiempo2TR = System.nanoTime()
    println(" Tiempo busqueda saltos (s): "+ ((tiempo2TR-tiempo1TR)/ 1000000000.0))

    tiempo1TR = System.nanoTime()
    System.nanoTime()
    busquedaSaltos[Int]((1 to 100000000).toArray,333, _<_)
    tiempo2TR = System.nanoTime()
    println(" Tiempo busqueda saltos (s): "+ ((tiempo2TR-tiempo1TR)/ 1000000000.0))

    tiempo1TR = System.nanoTime()
    System.nanoTime()
    busquedaSaltos[Int]((1 to 100000000).toArray,45000000, _<_)
    tiempo2TR = System.nanoTime()
    println(" Tiempo busqueda saltos (s): "+ ((tiempo2TR-tiempo1TR)/ 1000000000.0))

    tiempo1TR = System.nanoTime()
    System.nanoTime()
    busquedaSaltos[Int]((1 to 100000000).toArray,95000000, _<_)
    tiempo2TR = System.nanoTime()
    println(" Tiempo busqueda saltos (s): "+ ((tiempo2TR-tiempo1TR)/ 1000000000.0))
  }
}
