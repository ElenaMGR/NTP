package abstractas

abstract  class Coche {
  val fechaCompra: Int
  val automatico: Boolean = true
  def color: String
}

class MiniRojo(val fechaCompra: Int) extends Coche{
  def color = "rojo"
}

class Mini(val fechaCompra: Int, val color:String) extends Coche