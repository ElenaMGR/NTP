class Multiplicador(factor:Int) {
   def apply(valor: Int):Int = valor * factor
}

val porTres=new Multiplicador(3)

val prod1=porTres.apply(8)
val prod2=porTres(10)
