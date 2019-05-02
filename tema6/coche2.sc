class Coche(val marca:String, var enUso:Boolean=false) {
   override def toString=s"Marca: $marca, enUso: $enUso"
}

val c1=new Coche("Ford")
val c2=new Coche("Seat", true)
