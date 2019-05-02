// Esto debe ejecutarse en la consola
class A1{
   def mostrar="Clase A"
}

trait B1{self:A1 =>
   override def toString:String ="B: "+ mostrar
}

// Error: la clase C no puede extender B 1
// class C extends B1

class C extends A1 with B1

val objeto=new C
