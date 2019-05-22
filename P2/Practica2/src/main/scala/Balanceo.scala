object Balanceo {

  def chequearBalance(cadena: List[Char]): Boolean = {
    var abierto, cerrado = 0
    println(abierto)
    println(cerrado)
    if (cadena.isEmpty) true
    else if (cadena.head=='(') abierto+1

  }

  /**
    * Metodo main: en realidad no es necesario porque el desarrollo
    * deberia guiarse por los tests de prueba
    *
    * @param args
    */
  def main(args: Array[String]): Unit ={
    println("................... Balanceo de cadenas con paréntesis ...................")

    chequearBalance(List())
  }

}
