// expresión
20+10

// sentencia
val x = 5*20

// Siempre que tengo un res asociado es una expresión, si no es una sentencia


// Cualquier bloque devuelve la última sentencia
val cantidad={val x=50*20; x+10}

// los bloques se pueden anidar
{val a=1; {val b=a*2; {val c=b+4; c}}}

// expresión if
if(47 % 3 > 0) println("No es múltiplo")

// expresión if como sentencia
val z=3
val y=10
val max=if(z > y) z else y

// expresió incompleta
val max1 = if(z > y) true

// expresiones match (esencial en scala)
val maximo2 = (x > y) match{
  case true => x
  case false => y
}

val error = 500
val mensaje = error match{
  case 200 => "OK"
  case 400 => {
    println("Error ejecución")
    "Error 400"
  }
  case 500 => {
    println("Error sintáctico")
    "Error 500"
  }
  case _ => "Error desconocido"
}

val dia = "jueves"

val laborable = dia match{
  case "lunes" | "martes" | "miercoles" => "laborales"
  case "sabado" | "domingo" => "festivo"
  case otraCosa => {
    println("Procesado: "+otraCosa)
    "prefiesta"
  }
}

val p:Float = 12.34f
val q:Any = p

val respuesta = q match{
  case z:String => s"$z - String"
  case z:Double => f"$z%.2f - Double"
  case z:Float => f"$z%.2f - Float"
  case z:Long => s"${z} - Long"
}