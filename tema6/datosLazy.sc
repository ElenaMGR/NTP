class PuntoAleatorio{
   val x={
      println("Asignacion de x:")
      util.Random.nextInt
   }

   lazy val y={
      println("Asignacion de y:")
      util.Random.nextInt
   }
}

val p1=new PuntoAleatorio

println(s"Ubicacion en: ${p1.x}, ${p1.y}")
println(s"Ubicacion en: ${p1.x}, ${p1.y}")
