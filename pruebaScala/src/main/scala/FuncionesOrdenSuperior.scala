import java.io.File

import scala.annotation.tailrec

object BuscadorArchivos {
  private def archivos = (new File(".")).listFiles

  // metodo para buscar archivos con extension
  def archivosConExtension(extension : String) = {
    for (archivo <- archivos
      if(archivo.getName.endsWith(extension))) yield archivo
  }

  def archivoConCadena (cadena : String ) = {
    for (archivo <- archivos
      if archivo.getName.contains(cadena)) yield archivo
  }

  def archivoConExpresionRegular (expresion: String) ={
    for (archivo <- archivos
      if archivo.getName.matches(expresion)) yield archivo
  }
}

// Lo anterior mejorado
object BuscadorArchivosSimple {
  private def archivos = (new File(".")).listFiles

  def archivosCondicion(cadena:String, condicion : (String, String) => Boolean)={
    for (archivo <- archivos
      if (condicion(archivo.getName, cadena))) yield archivo
  }

  def archivosConExtension (extension:String) ={
    archivosCondicion(extension, _.endsWith(_))
    // Lo anterior es similiar a:
    //archivosCondicion(extension, (cadena1, cadena2)=>cadena1.endsWith(cadena2))
  }

  def archivosConCadena (cadena:String) ={
    archivosCondicion(cadena, _.contains(_))
  }

  def archivosConExpresionRegular (expresion:String) = {
    archivosCondicion(expresion, _.matches(_))
  }
}

object BuscadorArchivosMasSimple{
  private def archivos = (new File(".")).listFiles

  def archivosCondicion (condicion : String => Boolean) ={
    for (archivo <- archivos
      if condicion (archivo.getName)) yield archivo
  }

  def archivosConExtension (extension : String) ={
    archivosCondicion(_.endsWith(extension))
    // Equivalente a:
    //archivosCondicion(cadena => cadena.endsWith(extension))
  }
}

object OrdenacionGenerica extends App {
  def ordenado[A] (array:Array[A], criterio: (A, A) => Boolean) :Boolean ={
    @tailrec
    def go (indice: Int) : Boolean = {
      //primer caso base
      if (criterio(array(indice), array(indice+1))== false) false
      else{
        if (indice == array.length -2) criterio (array(indice), array(indice+1))
        else go (indice+1)
      }
    }
    go(0)
  }

  def ordenadoC[A](array:Array[A])(criterio:(A,A) => Boolean) : Boolean ={
    @tailrec
    def go (indice: Int) : Boolean = {
      //primer caso base
      if (criterio(array(indice), array(indice+1))== false) false
      else{
        if (indice == array.length -2) criterio (array(indice), array(indice+1))
        else go (indice+1)
      }
    }
    go(0)
  }

  val array1 : Array[Int] = Array(1,5,7,9,12)
  val resultado1 = OrdenacionGenerica.ordenado(array1, (x:Int, y:Int)=> x>y)
  println(resultado1)
  val resultado2 = OrdenacionGenerica.ordenadoC(array1)(_>_)
}
