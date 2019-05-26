import BusquedaBinariaGenerica.busquedaBinaria
import org.scalatest.FunSuite

class BBTest extends FunSuite {
  // Prueba 1
  test("lista contiene número") {
    var numeros = (1 to 100).toArray
    var indice = busquedaBinaria[Int](numeros,28,_<_)
    assert(indice==numeros.indexOf(28))
  }

  // Prueba 2
  test("lista no contiene número") {
    var numeros = (1 to 100).toArray
    var indice = busquedaBinaria[Int](numeros,102,_<_)
    assert(indice==numeros.indexOf(102))
  }

  // Prueba 3
  test("comprobar elemento medio") {
    var numeros = (1 to 10).toArray
    var indice = busquedaBinaria[Int](numeros,5,_<_)
    assert(indice==numeros.indexOf(5))
  }


}
