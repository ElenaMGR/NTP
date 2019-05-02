abstract class Listener{
   def trigger
}

class Listening{
   var listener:Listener=null
   def registrar(l:Listener){listener=l}
   def notificar(): Unit ={
      listener.trigger
   }
}

val obj1=new Listening
obj1.registrar(new Listener{
   def trigger: Unit ={
      println(s"Activacion en ${new java.util.Date}")
   }
})

obj1.notificar

