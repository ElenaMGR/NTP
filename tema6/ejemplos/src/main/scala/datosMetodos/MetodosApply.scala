package datosMetodos

class Multiplicador(val factor:Int){
  def apply(valor:Int) = valor*factor
}

// companion object
object Multiplicador{
  def apply(factor: Int) = new Multiplicador(factor)
}

object MetodosApply extends App {
  val multiplicador = new Multiplicador(3)
  println("multiplicador por 3 x 10: "+multiplicador.apply(10))
  println("multiplicador por 3 x 10: "+multiplicador(10))

  val lista1=List(1,2,3,4,5,6,7)
  val dato1=lista1(4) // que metodo se llama? apply

  val multiplicador2 = Multiplicador(5)

}
