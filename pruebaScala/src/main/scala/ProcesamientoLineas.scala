import scala.io.Source

object ProcesamientoLineas {

  def imprimirLineas (nombreArchivo : String) : Unit = {
    val lineas = Source.fromFile(nombreArchivo).getLines().toList

    for (linea <- lineas)
      println(linea.length + " "+linea)
  }

  def calcularAnchoTamLinea (linea:String) = linea.length.toString.length

  def imprimirLineasV2 (nombreArchivo : String) : Unit = {
    val lineas = Source.fromFile(nombreArchivo).getLines().toList

    //determinar linea mas larga
    var maximoAnchoTam=0
    for (linea <- lineas){
      maximoAnchoTam = maximoAnchoTam.max(calcularAnchoTamLinea(linea))
    }
     //forma mas funcional del for
    //lineas.map(linea => calcularAnchoTamLinea(linea)).max
    /*lineas.foldLeft(0)((max,linea) => {
      val anchoLinea = calcularAnchoTamLinea(linea)
      if (anchoLinea > max) anchoLinea
      else max
    })*/

    // se utiliza maximoAnchoTam para rellenar espacios
    for (linea <- lineas){
      val tamLinea = calcularAnchoTamLinea(linea)
      val relleno = " "+(maximoAnchoTam - tamLinea)
      println(relleno+linea.length+"|"+linea)
    }
  }

  def imprimirLineasV3 (nombreArchivo : String): Unit = {
    val lineas = Source.fromFile(nombreArchivo).getLines().toList

    //determinar linea mas larga
    val lineaMasLarga = lineas.reduceLeft((a,b) => if (a.length > b.length) a else b)

    val maximoAnchoTam = calcularAnchoTamLinea(lineaMasLarga)

    // se utiliza maximoAnchoTam para rellenar espacios
    for (linea <- lineas){
      val tamLinea = calcularAnchoTamLinea(linea)
      val relleno = " "+(maximoAnchoTam - tamLinea)
      println(relleno+linea.length+"|"+linea)
    }
  }

  def main(args : Array[String]) : Unit = {
    if (args.length > 0){
      imprimirLineasV3(args(0))
    }
  }
}
