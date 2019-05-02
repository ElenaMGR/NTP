class Impresora(mensaje:String){
   def imprimir(cadena:String):Unit =
      println(s"$mensaje: $cadena")

   def imprimir(cadenas:Seq[String]):Unit =
      println(mensaje, cadenas.mkString("\n"))
}

val objeto=new Impresora("epson m200")

objeto.imprimir("documento corto")

objeto.imprimir("linea 1" :: "linea 2" :: "linea 3" :: Nil)


