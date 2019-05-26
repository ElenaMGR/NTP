object CambioMoneda {
  def listarCambiosPosibles(cantidad: Int, monedas: List[Int]): List[List[Int]] = {
    devolverMonedas(cantidad,monedas.sorted, List[List[Int]](), List[Int]())
  }


  def devolverMonedas(cantidad: Int, monedas: List[Int],soluciones:List[List[Int]],monedaActual:List[Int]): List[List[Int]] = {
    if(monedas.isEmpty || cantidad<0) soluciones
    else if(cantidad == 0) monedaActual::soluciones
    else{
      devolverMonedas(cantidad-monedas.head,monedas,soluciones,monedas.head::monedaActual) :::
        devolverMonedas(cantidad,monedas.tail,soluciones,monedaActual)
    }
  }


  /**
    * Metodo main: en realidad no es necesario porque el desarrollo
    * deberia guiarse por los tests de prueba
    *
    * @param args
    */
  def main(args: Array[String]): Unit ={
    println("................... Cambio de Monedas ...................")

    println(listarCambiosPosibles(0,List(1,2)))

  }
}
