object TrianguloPascal {
  def calcularValorTrianguloPascal (fila : BigInt, columna : BigInt) : BigInt ={
    if (columna == 0 || columna == fila) 1
    else factorial(fila)/(factorial(columna)*factorial(fila-columna))
  }

  @annotation.tailrec
  def factorial (x: BigInt, acum:BigInt = 1): BigInt ={
    if (x==0 || x == 1) acum
    else factorial(x-1,x*acum)
  }

  /**
    * Metodo main: en realidad no es necesario porque el desarrollo
    * deberia guiarse por los tests de prueba
    *
    * @param args
    */
  def main(args: Array[String]): Unit ={
    println("................... Triangulo de Pascal ...................")

    // Se muestran 10 filas del trinagulo de Pascal
    for (row <- 0 to 10) {
      // Se muestran 10 y 10 filas
      for (col <- 0 to row)
        print(calcularValorTrianguloPascal(row, col) + " ")
      // Salto de linea final para mejorar la presentacion
      println()
    }

    // Se muestra el valor que debe ocupar la columna 5 en la fila 10
    print(calcularValorTrianguloPascal(10, 5))
  }

}
