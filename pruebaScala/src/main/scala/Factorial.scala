object Factorial extends App{
  // Función factorial
  def factorial (x : Int) :Int = {
    if (x == 0) 1
    else x * factorial(x-1)
  }

  // para saber si la recursividad es por la cola se usa @annotation.tailrec

  @annotation.tailrec
  def factoriaTR (x : Int, acum: Int) : Int ={
    if (x == 0) acum
    else factoriaTR(x-1, acum*x)
  }

  val factorial4 = factoriaTR(4,1)

  def factorialTRSimple (x : Int) : BigInt = {
    @annotation.tailrec
    def go (x : BigInt, acum : BigInt) : BigInt = {
      if (x == 0) acum
      else go (x-1, x*acum)
    }
    //desencadena la ejecucion de go
    go(x,1)
  }

  val factorial30 = factorialTRSimple(30)
  println(factorial30)
}
