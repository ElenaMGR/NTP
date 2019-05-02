
class A(final val datoFinal:Int, val datoNormal:Int) {
   override def toString(): String ={
      s"datoFinal: $datoFinal - datoNormal: $datoNormal"
   }
}

// Error por intentar redefinir datoFInal
// class B(val datoFinal:Int, dato1:Int) extends A(datoFinal, dato1)

class C(final val datoFinal:Int, val datoNormal:Int) {
   final override def toString(): String ={
      s"datoFinal: $datoFinal - datoNormal: $datoNormal"
   }
}

class D(val dato1:Int, val dato2:Int) extends C(dato1, dato2){
   // Problema por redefinir toString
   //override def toString() = {
   //}
}

final class E

// Herencia no permitida
//class F extends E

object ejemploFinal extends App{
}
