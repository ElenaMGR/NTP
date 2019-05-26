import CambioMoneda.listarCambiosPosibles
import org.scalatest.FunSuite

class CambioMonedaTest extends FunSuite {
  // Prueba 1
  test("cambio de moneda, cantidad = 4") {
    var lista = listarCambiosPosibles(4,List(1,2))
    assert(lista.size==3)
    assert(lista(0)==List(1,1,1,1))
    assert(lista(1)==List(2,1,1))
    assert(lista(2)==List(2,2))
  }

  //Prueba 2
  test ("lista 1 elemento"){
    var lista = listarCambiosPosibles(4,List(2))
    assert(lista.size==1)
    assert(lista(0)==List(2,2))
  }

  //Prueba 3
  test ("lista sin monedas"){
    var lista = listarCambiosPosibles(4,List())
    assert(lista.size==0)
  }

  //Prueba 4
  test ("cantidad 0"){
    var lista = listarCambiosPosibles(0,List(1,2))
    assert(lista.size==1)
    assert(lista(0).size==0)
  }

  //Prueba 5
  test ("monedas por encima de la cantidad"){
    var lista = listarCambiosPosibles(3,List(5,6,7))
    assert(lista.size==0)
  }

}
