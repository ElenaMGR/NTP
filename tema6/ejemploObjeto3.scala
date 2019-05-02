
class Multiplicador(val x:Int) {
   def producto(y:Int) = x*y
}

object Multiplicador{
   def apply(x:Int)=new Multiplicador(x)
}

object ejemploObjeto3 extends App{
   val porTres=Multiplicador(3)
   val resultado=porTres.producto(4)
   println("Resultado: "+resultado)
}
