object FuncionesAnidadas extends App {
  def max(x:Int,y:Int,z:Int) ={
    // función auxiliar
    def max(x:Int,y:Int) = if (x>y) x else y

    // desencadenar la ejecucion
    max (x, max(y,z))
  }

  val maximo = max (9,5,12)
  println(maximo)

}
