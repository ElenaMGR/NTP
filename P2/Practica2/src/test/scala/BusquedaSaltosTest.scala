import BusquedaSaltosGenerica.busquedaSaltos
import org.scalatest.FunSuite

class BusquedaSaltosTest extends FunSuite {
  // Prueba 1
  test("busqueda saltos") {
    var resultados = List(-1,-1,-1,-1,0,1,2,3,4,5,6,7,8,9,10,-1)
    for (i <- (-3 to 12))
      assert(resultados(i+3)==busquedaSaltos[Int]((1 to 11).toArray,i,_<_))
  }



}
