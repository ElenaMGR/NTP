
class TestSuite(nombre:String) {
   def comienzo(): Unit ={
      println("Inicio de ejecucion de TestSuite")
   }
}

trait SemillaAleatoria{self:TestSuite =>
   def inicioAleatorio(): Unit ={
      util.Random.setSeed(System.currentTimeMillis)
      self.comienzo()
   }
}

class PruebaId extends TestSuite("Test ID") with SemillaAleatoria {
   def testId(): Unit ={
      println(util.Random.nextInt != 1)
   }

   override def comienzo(): Unit ={
      testId()
   }

   println("Inicio de PruebaID...........")
   inicioAleatorio()
}

object EjemploTrait4 extends App{
   val objeto=new PruebaId
}
