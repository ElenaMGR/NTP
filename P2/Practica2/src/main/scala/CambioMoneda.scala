object CambioMoneda {
  def listarCambiosPosibles(cantidad: Int, monedas: List[Int]): List[List[Int]] = {
    if (cantidad == 0 || monedas.isEmpty) List(List(0))
    else {
      var monedasOrdenadas = monedas.sorted
      List(List(0,1,2))
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
