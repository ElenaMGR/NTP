abstract class Listener{
   def trigger
}

val miListener = new Listener {
   def trigger: Unit ={
      println(s"Activacion en ${new java.util.Date}")
   }
}

miListener.trigger
