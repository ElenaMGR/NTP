import scala.annotation.tailrec

/**
  * Define un dato miembro que permite almacenar la función característica.
  *
  * @param funcionCaracteristica función que recibe como argumento un valor entero y devuelve un valor
  *                              booleano indicando pertenencia o no
  */
class Conjunto (val funcionCaracteristica: Int => Boolean) {

  private final val LIMITE = 100

  /**
    * Comprueba si un valor pertenece o no al conjunto
    *
    * @param valor valor entero a comprobar si pertenence al conjunto
    * @return si pertenece o no al cunjunto
    */
  def apply (valor: Int): Boolean  = {
    funcionCaracteristica(valor)
  }

  /**
    * Ofrece una visión del contenido del conjunto.
    * Para visualizar el conjunto se asume que se itera sobre un rango de valores dado por una
    * constante llamada LIMITE (desde -LIMITE hasta +LIMITE) y se muestran aquellos que pertenecen al conjunto.
    *
    * @return visualización del conjunto
    */
  override def toString: String = {
    val elementos = for (
      i <- -LIMITE to LIMITE
      if apply(i))
      yield i

    elementos.mkString("{", ", ", "}")
  }


}

/**
  * Objeto companion
  */
object Conjunto {

  /**
    * Creación de un conjunto dado por un único elemento
    *
    * @param elemento elemento para crear el conjunto
    * @return el conjunto con el elemento
    */
  def conjuntoUnElemento (elemento: Int): Conjunto = {
    new Conjunto ((x:Int) => x == elemento)
  }

  /**
    * Dados dos objetos de la clase Conjunto produce su unión
    *
    * @param c1 objeto de la clase Conjunto
    * @param c2 objeto de la clase Conjunto
    * @return conjunto con la unión de c1 y c2
    */
  def union (c1:Conjunto, c2:Conjunto): Conjunto = {
    new Conjunto ((x:Int) => c1.funcionCaracteristica(x) || c2.funcionCaracteristica(x))
  }

  /**
    * Dados dos objetos de la clase Conjunto produce su interseccion
    *
    * @param c1 objeto de la clase Conjunto
    * @param c2 objeto de la clase Conjunto
    * @return conjunto con la interseccion de c1 y c2
    */
  def interseccion (c1:Conjunto, c2:Conjunto): Conjunto = {
    new Conjunto ((x:Int) => c1.funcionCaracteristica(x) && c2.funcionCaracteristica(x))
  }

  /**
    * Diferencia de dos objetos (el conjunto resultante está formado por aquellos
    * valores que pertenecen al primer conjunto, pero no al segundo).
    *
    * @param c1 objeto de la clase Conjunto
    * @param c2 objeto de la clase Conjunto
    * @return conjunto con la diferencia de c1 y c2
    */
  def diferencia (c1:Conjunto, c2:Conjunto): Conjunto = {
    new Conjunto ((x:Int) => c1.funcionCaracteristica(x) && !c2.funcionCaracteristica(x))
  }

  /**
    * Dado un conjunto y una función tipo Int => Boolean, devuelve como resultado
    * un conjunto con los elementos que cumplen la condición indicada.
    *
    * @param c conjunto a filtrar
    * @param condicion condicion para filtrado
    * @return conjunto filtrado
    */
  def filtrar (c: Conjunto, condicion: Int => Boolean): Conjunto = {
    new Conjunto ((x:Int) => c.funcionCaracteristica(x) && condicion(x))
  }

  /**
    * Comprueba si un determinado predicado se cumple para todos los elementos
    * del conjunto. Esta función debe implementarse de forma recursiva, definiendo una función
    * auxiliar, ya que hay que iterar sobre el rango de valores dado por LIMITE.
    *
    * @param c conjunto a comprobar
    * @param predicado predicado a evaluar sobre el conjunto
    * @return si el predicado se cumple para todo el conjunto
    */
  def paraTodo (c: Conjunto, predicado: Int => Boolean): Boolean = {

    @tailrec
    def comprobar(elemento: Int): Boolean = {
      if(elemento == c.LIMITE+1){
        true
      }
      else if(!c.funcionCaracteristica(elemento)){
        comprobar(elemento+1)
      }
      else{
        predicado(elemento) && comprobar(elemento + 1)
      }
    }

    comprobar(-c.LIMITE)
  }

  /**
    * Determina si un conjunto contiene al menos un elemento para el que se cumple
    * un cierto predicado. Debe basarse en el método anterior.
    *
    * @param c conjunto a comprobar
    * @param predicado predicado a evaluar sobe el conjunto
    * @return si el conjunto contiene un elemento que cumple el predicado
    */
  def existe (c: Conjunto, predicado: Int => Boolean): Boolean = {
    // Haciendo uso de la lógica de predicados
    // decir que existe elemento en el conjunto que cumple el predicado implica
    // que no para todos los elemento del conjunto se cumpla la negación del predicado
    !paraTodo(c, (x: Int) => !(predicado(x)))
  }

  /**
    * Transforma un conjunto en otro aplicando una cierta función.
    *
    * @param c conjunto de entrada
    * @param funcion funcion a aplicar sobre el conjunto
    * @return conjunto con la funcion aplicada
    */
  def map (c: Conjunto, funcion: Int => Int): Conjunto = {
    new Conjunto(
      (x:Int) => existe(c,(y:Int) => x == funcion(y))
    )
  }

}


object Prueba extends App{
  val c = Conjunto.conjuntoUnElemento(1)
  val c2 = Conjunto.conjuntoUnElemento(2)
  println(c.toString)
  println(c2.toString)

  val cUnion = Conjunto.union(c,c2)
  println("union"+cUnion.toString)

  val cInter = Conjunto.interseccion(c2, cUnion)
  println("Interseccion"+cInter.toString)

  val cDif = Conjunto.diferencia(cUnion, c2)
  println("Diferencia"+cDif.toString)

  val filtrado = Conjunto.filtrar(cUnion,(x:Int) => x>1)
  println("Filtrado"+filtrado.toString)

  val con = new Conjunto((x:Int)=> x>3 && x<11)
  println(con.toString)

  val menores5 = Conjunto.paraTodo(con,(x:Int) => x<5)
  println("Menoes 5: "+menores5)

  val menores10 = Conjunto.paraTodo(con,(x:Int) => x<10)
  println("Menoes 10: "+menores10)

  val menores11 = Conjunto.paraTodo(con,(x:Int) => x<11)
  println("Menoes 11: "+menores11)

  val existe3 = Conjunto.existe(con,(x:Int) => x==3)
  println("Existe 3: "+existe3)

  val existe7 = Conjunto.existe(con,(x:Int) => x==7)
  println("Existe 7: "+existe7)

  val valorx2 = Conjunto.map(con, (x=>x*2) )
  println("Valores x 2: "+valorx2.toString)
}