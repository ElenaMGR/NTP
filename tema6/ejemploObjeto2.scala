
object UtilidadesHtml{
   def quitarMarca(entrada:String):String = {
      entrada.replaceAll("""</?\w[^>]*>""","").
              replaceAll("<.*>","")
   }
}

object ejemploObjeto2 extends App{
   val res=UtilidadesHtml.quitarMarca("<html><body><h1>Introduction</h1></body></html>")
   println("Resultado: "+res)
}
