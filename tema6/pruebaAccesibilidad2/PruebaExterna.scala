package pruebaAccesibilidad2

/**
  * Created by mgomez on 23/4/17.
  */
object PruebaExterna extends App{
   // Esto no puede hacerse
   // println(s"Direccion web: ${new Configuracion().url}")

   // Si es posible hacer uso de la clase Autenticacion
   val valido=new pruebaAccesibilidad1.Autenticacion().validar
   println(valido)
}
