import org.scalacheck.{Gen, Properties}
import org.scalacheck.Prop.forAll
import org.scalacheck.Gen._
object BBCheck extends Properties("Busqueda Binaria"){
  //Genero lista de enteros
  val enteros = listOf(Gen.choose(1, 100))

  property("Busqueda binaria generica") = {
    forAll(enteros) { (numeros) =>
      val enterosOrdenados = numeros.sorted
      val valorABuscar = Gen.choose(1, 100).sample.getOrElse(0)
      val indice = enterosOrdenados.indexOf(valorABuscar)
      val indiceBusquedaBinaria = BusquedaBinariaGenerica.busquedaBinaria[Int](enterosOrdenados.toArray, valorABuscar, _ < _)

      (indice == indiceBusquedaBinaria) || (enterosOrdenados(indice) == enterosOrdenados(indiceBusquedaBinaria))

    }
  }
}
