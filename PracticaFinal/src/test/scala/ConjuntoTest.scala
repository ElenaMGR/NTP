import org.scalatest.FunSuite

class ConjuntoTest extends FunSuite {
  val c1 = new Conjunto((x:Int)=> x>0 && x<11)
  val c2 = new Conjunto((x:Int)=> x>5 && x<16)
  // Test creación conjunto
  test("chequear creación conjunto:") {
    println("Conjunto 1: "+c1.toString)
    println("Conjunto 2: "+c2.toString)
    assert(c1.funcionCaracteristica(5), "Error: no contiene elemento esperado")
    assert(c2.funcionCaracteristica(10), "Error: no contiene elemento esperado")
  }

  // Test toString
  test ("chequear toString"){
    val c3 = Conjunto.conjuntoUnElemento(1)
    val vC3 = "{1}"
    assert(c3.toString==vC3)

    val c4 = new Conjunto((x:Int)=> x>0 && x<3)
    val vC4 = "{1, 2}"
    assert(c4.toString==vC4)
  }

  // Test conjuntoUnElemento
  test ("chequear conjuntoUnElemento"){
    val c3 = Conjunto.conjuntoUnElemento(1)
    assert(c3(1),"El conjunto no contiene un 1")
  }

  // Test union
  test ("chequear union"){
    val c3 = Conjunto.union(c1,c2)
    println("Union: "+c3.toString)
    assert(c3(5), "Error, no contiene los elementos del primer conjunto")
    assert(c3(15), "Error, no contiene los elementos de segundo conjunto")
  }

  // Test Interseccion
  test ("chequear interseccion"){
    val c3 = Conjunto.interseccion(c1,c2)
    println("Interseccion: "+c3.toString)
    assert(!c3(5), "Error, contiene elementos del primer conjunto")
    assert(!c3(15), "Error, contiene elementos de segundo conjunto")
    assert(c3(7), "Error, no funciona interseccion")
  }

  // Test Diferencia
  test ("chequear diferencia"){
    val c3 = Conjunto.diferencia(c1,c2)
    println("Diferencia: "+c3.toString)
    assert(c3(5), "Error, no funciona diferencia")
    assert(!c3(15), "Error, no funciona diferencia")
    assert(!c3(7), "Error, no funciona diferencia")
  }

  // Test Filtro
  test ("chequear filtro"){
    val c3 = Conjunto.filtrar(c1,x=> x>2 )
    println("Filtrado x>2: "+c3.toString)
    assert(!c3(1))
    assert(c3(5))
  }

  // Test ParaTodo
  test ("chequear paraTodo"){
    assert(!Conjunto.paraTodo(c1,x=> x>2 ))
    assert(Conjunto.paraTodo(c1,x=> x>0 ))
  }

  // Test Existe
  test ("chequear existe"){
    assert(Conjunto.existe(c1,x=> x>2 ))
    assert(Conjunto.existe(c1,x=> x==3 ))
    assert(!Conjunto.existe(c1,x=> x==18 ))
  }

  // Test Map
  test ("chequear map"){
    val c3 = Conjunto.map(c1,(x=>x*2))
    println("Valores x 2: "+c3.toString)
    assert(c1(1) && !c3(1))
    assert(!c1(12) && c3(12))
  }

}
