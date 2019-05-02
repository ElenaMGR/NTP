class Coche(val marca:String, var enUso:Boolean){
   def reservar(r:Boolean):Unit = {
      enUso=r
   }
}

val c1=new Coche("Toyota", true)
c1.reservar(false)
println(s"Vehiculo: ${c1.marca}, estado: ${c1.enUso}")

// Se usan parametros con nombre
val c2=new Coche(enUso=false, marca="Suzuki")

class Renault(val color:String, enUso:Boolean)
   extends Coche("Renault", enUso)

val c3=new Renault("rojo", false)
