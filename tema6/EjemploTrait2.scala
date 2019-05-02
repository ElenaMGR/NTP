
trait UtilidadesHtmlTrait2{
   def quitarMarca(entrada:String):String = {
      entrada.replaceAll("""</?\w[^>]*>""","").
         replaceAll("<.*>","")
   }
}

trait OperacionSeguraString{
   def eliminarEspacios(cadena:String):Option[String] = {
      Option(cadena) map (_.trim) filterNot(_.isEmpty)
   }
}

class Pagina1(val contenido:String) extends UtilidadesHtmlTrait2
                                   with OperacionSeguraString{
   def comoTextoPlano:String = {
      eliminarEspacios(contenido) map quitarMarca getOrElse "n/a"
   }
}

object EjemploTrait2 extends App{
   val pagina:Pagina1=new Pagina1("<html><body><h1>Introduction</h1></body></html>")
   println(pagina.comoTextoPlano)
}
