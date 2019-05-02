
trait UtilidadesHtmlTrait{
   def quitarMarca(entrada:String):String = {
      entrada.replaceAll("""</?\w[^>]*>""","").
         replaceAll("<.*>","")
   }
}

class Pagina(val contenido:String) extends UtilidadesHtmlTrait {
   def comoTextoPlano=quitarMarca(contenido)
}

object EjemploTrait extends App{
   val pagina:Pagina=new Pagina("<html><body><h1>Introduction</h1></body></html>")
   println(pagina.comoTextoPlano)
}
