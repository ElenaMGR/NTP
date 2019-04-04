import Factorial.factorial

object Fibonacci extends App{

  /**
    * Función para calcular la sucesión de Fibonacci
    * @param x
    * @return
    */
  def FibonacciSimple (x : Int) :Int = {
    //caso base
    if (x == 0 || x == 1) x
    else FibonacciSimple(x-2) + FibonacciSimple(x-1)
  }


  def Fibonacci (x : Long) : Long = {
    @annotation.tailrec
    def go (x : Long, previo : Long, actual : Long) : Long = {
      if (x == 0) previo
      else go (x-1, actual, actual + previo)
    }
    // llamada inicial a go
    go(x,0,1)
  }

  val tiempo1 = System.nanoTime()
  val f = FibonacciSimple(20)
  val tiempo2 = System.nanoTime()
  //println(f+ " Tiempo sin TR: "+ tiempo2-tiempo1)
  println(tiempo2-tiempo1)

  val tiempo1TR = System.nanoTime()
  val f2 = Fibonacci(20)
  val tiempo2TR = System.nanoTime()
  //println(f2+ " Tiempo con TR: "+ tiempo2TR-tiempo1TR)

}
