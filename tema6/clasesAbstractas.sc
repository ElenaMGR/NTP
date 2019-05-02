abstract class Coche{
   val fechaCompra:Int
   val automatico:Boolean=true

   def color:String
}

// No pueden crearse objetos de clase abstractas
// new Coche
class MiniRojo(val fechaCompra:Int) extends Coche{
   def color="Rojo"
}

val coche=new MiniRojo(2016)

class Mini(val fechaCompra:Int, val color:String) extends Coche

val c2:Coche = new Mini(2015,"rojo")
