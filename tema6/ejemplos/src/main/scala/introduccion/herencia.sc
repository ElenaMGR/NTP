class A{
  def mensaje="Saludos desde "+getClass.getName
  override def toString:String = getClass.getName
}

class B extends A

class C extends B{
  override def mensaje = "Saludos desde C -> "+ super.mensaje
}

val objA=new A
val objB = new B
val objC = new C

objA.mensaje
objB.mensaje
objC.mensaje

val refA1:A=objA
val refA2:A=objB
val refA3:A=objC

refA1.mensaje
refA2.mensaje
refA3.mensaje

val lista=List(objA, objB, objC)
