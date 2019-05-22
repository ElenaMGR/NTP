import org.scalacheck.{Gen, Properties}
import org.scalacheck.Prop.forAll

object BalanceoCheck extends Properties("Balanceo"){
  var MAXIMALONGITUD = 1000

  // Generacion de cadenas de longitud n: forma de uso strGen(10) para cadenas
  // de 10 caracteres
  val strGen =
  (n: Int) =>
    Gen.listOfN(n, Gen.oneOf('(',')',Gen.alphaChar.sample.get)).
      map(_.mkString)

  // propiedad
  property("Balance de cadenas") = {
    forAll(strGen(Gen.choose(1,MAXIMALONGITUD).sample.get)) {
      cadena => {
        val condition=Balanceo.chequearBalance(cadena.toList)
        for(i <- 2 until cadena.length) {
          val substring=cadena.substring(0,i)
          val openCount=substring.filter(c => c == '(').length
          val closeCount=substring.filter(c => c == ')').length
          condition == ((openCount-closeCount) >= 0)
        }
      }
        true
    }
  }
}
