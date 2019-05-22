object Balanceo {

  def chequearBalance(cadena: List[Char]): Boolean = {

    @annotation.tailrec
    // acum = "(" - ")" -> resultado de abiertos menos cerrados
    def go(cadena: List[Char], acum: Int = 0): Boolean = {
      if (cadena.isEmpty && acum==0) true
      else if (cadena.isEmpty && acum!=0) false
      // "(" - ")" nunca debe ser negativo
      else if(acum < 0) false
      // Si head = ( sumamos uno a acum y llamamos a go
      else if(cadena.head == '(') go(cadena.tail,acum+1)
      // Si head = ) restamos uno a acum y llamamos a go
      else if(cadena.head == ')') go(cadena.tail,acum-1)
      // Si head es distinto de ( y ) llamamos a go sin modificar acum
      else go(cadena.tail,acum)
    }
    go(cadena,0)
  }

  /**
    * Metodo main: en realidad no es necesario porque el desarrollo
    * deberia guiarse por los tests de prueba
    *
    * @param args
    */
  def main(args: Array[String]): Unit ={
    println("................... Balanceo de cadenas con paréntesis ...................")

    println(chequearBalance("(if (a ¿ b) b/a) else (a/(b*b)))".toList))
    println(chequearBalance("(((".toList))
    println(chequearBalance("(ccc(ccccc((ccc(c))))".toList))
    println(chequearBalance("())()())".toList))
    println(chequearBalance("())(".toList))
    println(chequearBalance("(if (a ¿ b) (b/a) else (a/(b*b)))".toList))
    println(chequearBalance("(ccc(ccc)cc((ccc(c))))".toList))

  }

}
