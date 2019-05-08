package finalSealed

class A(final val datoFinal:Int, val datoNormal:Int){
  final override def toString : String = {
    s"dato final: $datoFinal - dato normal: $datoNormal"
  }
}

//class B(val datoFinal:Int, data1:Int) extends A(datoFinal, data1)

class C(override val datoNormal: Int) extends A(5,datoNormal){
  //override def toString : String = "metodo propio clase C"
}

// No se puede extender de esta clase porque es final
final class D

//class E extends D

// Solo se puede hacer dentro de este archivo porque la clase es sealed (sellada)
sealed class G

class H extends G

object EjemploFinal {

}
