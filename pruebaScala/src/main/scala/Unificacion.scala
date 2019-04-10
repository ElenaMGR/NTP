class LiteralFuncion {
  // literal tipo funcion
  val sum = (a : Int, b : Int) => a+b
}

// companion object
object LiteralFuncion extends App{
  val obj = new LiteralFuncion

  println("llamada a suma sobre obj: "+obj.sum(2,7))

  def ejecutarOperacion(funcion : (Int, Int) => Int, a : Int, b : Int) : Int = {
    funcion(a,b)
  }

  println("llamada con ejecutar: "+ejecutarOperacion(obj.sum, 10,20))
}

class FuncionSuma extends Function2[Int,Int,Int]{
  override def apply(v1:Int,v2:Int) : Int = {
    println("llamada a apply sobre FuncionSuma")
    v1+v2
  }
}

class ObjetoFuncion{
  val sum = new FuncionSuma

  def ejecutarOperacion(funcion: (Int,Int) => Int, a:Int, b:Int) : Int = {
    funcion(a,b)
  }
}

object ObjetoFuncion extends App{
  val obj = new ObjetoFuncion

  println("llamada a suma desde obj: "+obj.sum(8,10))

  println(" Suma sobre ejecutar: "+obj.ejecutarOperacion(obj.sum,10,20))
}