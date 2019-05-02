
class A1{
   val a:Int=3
   val b:Int=5

   def sumarDatos():Int = {
      a+b
   }
}

object ObjetoHeradaA extends A1{
}

object ObjetoHeredaClase extends App{
   val res=ObjetoHeradaA.sumarDatos()
   println(res)
}
