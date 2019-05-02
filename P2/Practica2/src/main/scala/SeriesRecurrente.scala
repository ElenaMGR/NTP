object SeriesRecurrente {

  def SeriesGenerica (x: Long, p: Long, a: Long, c1: Long, c2: Long) : Long = {
    @annotation.tailrec
    def go (x : Long, previo : Long, actual : Long) : Long = {
      if (x == 0) previo
      else go (x-1, actual, c1*actual + c2*previo)
    }
    // llamada inicial a go
    go(x,p,a)
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

  def Lucas (x : Long) : Long = {
    @annotation.tailrec
    def go (x : Long, previo : Long, actual : Long) : Long = {
      if (x == 0) previo
      else go (x-1, actual, actual + previo)
    }
    // llamada inicial a go
    go(x,2,1)
  }

  def Pell (x : Long) : Long = {
    @annotation.tailrec
    def go (x : Long, previo : Long, actual : Long) : Long = {
      if (x == 0) previo
      else go (x-1, actual, 2*actual + previo)
    }
    // llamada inicial a go
    go(x,2,6)
  }

  def PellLucas (x : Long) : Long = {
    @annotation.tailrec
    def go (x : Long, previo : Long, actual : Long) : Long = {
      if (x == 0) previo
      else go (x-1, actual, 2*actual + previo)
    }
    // llamada inicial a go
    go(x,2,2)
  }

  def Jacobsthal (x : Long) : Long = {
    @annotation.tailrec
    def go (x : Long, previo : Long, actual : Long) : Long = {
      if (x == 0) previo
      else go (x-1, actual, actual + 2*previo)
    }
    // llamada inicial a go
    go(x,0,1)
  }


  /**
    * Metodo main: en realidad no es necesario porque el desarrollo
    * deberia guiarse por los tests de prueba
    *
    * @param args
    */
  def main(args: Array[String]): Unit ={
    println("................... Series definidas de forma recurrente ...................")
    println(Fibonacci(20))
    println(SeriesGenerica(20,0,1,1,1))

  }

}
