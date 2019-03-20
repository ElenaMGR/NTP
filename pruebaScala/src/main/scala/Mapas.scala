object Mapas extends App {
  // creación de un conjunto (invariable)
  var ciudades = Set("Granada", "Jaen", "Malaga", "Almeria")

  ciudades += "Sevilla"
  println(ciudades)

  //las sentencias import en scala pueden aparecer en cualquier lugar
  import scala.collection.mutable.Set
  val asignaturas = Set("Matematicas", "Lengua", "Dibujo")
  asignaturas += "Fisica"
  println(asignaturas)

  import scala.collection.immutable.HashSet
  val colores = HashSet("rojo", "amarillo", "verde")

  // creación de map
  val dias = Map(1 -> "Lunes", 2 -> "Martes", 3-> "Miercoles")
  println(dias)

  // tamaño del mapa
  println("tamaño del mapa: "+ dias.size)

  val masDias = dias + (4 -> "Jueves")
  println(masDias)

  // determinar si contiene una clase
  val contine = masDias.contains(5)

  // acceder a todas las claves y valores
  val claves: Predef.Set[Int] = dias.keySet
  val valores: Iterable[String] = dias.values
  println("primer valor: "+valores.head)
  println("ultimo valor: "+valores.last)

  // fromas de acceso a las entradas
  val primerDia: Option[String] = dias.get(1)
  val primerDia2: String = dias.get(1).getOrElse("nulo")
  val segundoDia: String = dias(2) //Si no existe salta una excepcion (NoSuchElementException)

  //mapas heterogeneos
  val mapaHeterogeneo: Map[Any, Any] = Map(1 -> "Lunes", 2 -> "Martes", "Jueves" -> 4)

  // mapas con valores por defecto
  val diasDefecto = Map(1 -> "Lunes", 2 -> "Martes") withDefaultValue("fiesta")
  println("clave inexistente: "+diasDefecto(5))

  //forma de quitar entradas
  println(dias - (1))
  println(dias - (1,2))
  println(dias -- List(1,2))

}
