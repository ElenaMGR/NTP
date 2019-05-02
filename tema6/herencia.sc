class A{
   def mensaje="Saludo desde "+getClass.getName
   override def toString=getClass.getName
}

class B extends A

class C extends B {
   override def mensaje="Saludo desde C -> " +
      super.mensaje
}

val objA=new A
val objB=new B
val objC=new C

objA.mensaje
objB.mensaje
objC.mensaje

val refA1:A=new A
val refA2:A=new B
val refA3:A=new C

// Esto no puede hacerse: produce error
// val refB:B=new A()

val lista=List(new A, new B, new C)


