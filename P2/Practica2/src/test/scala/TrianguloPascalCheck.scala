import org.scalacheck.{Gen, Properties}
import org.scalacheck.Prop.forAll

object TrianguloPascalCheck extends Properties("Triangulo Pascal"){
  private val MAXIMO=30

  // generador
  val coordenadasExtremos = for{
    fila <- Gen.choose(0, MAXIMO)
    columna <- Gen.oneOf(0, fila)
  } yield (fila, columna)

  // propiedad
  property("Elementos en lados del triangulo valen 1") = {
    forAll(coordenadasExtremos) { (i) => {
      val resultado = TrianguloPascal.calcularValorTrianguloPascal(i._1, i._2)
      println("Fila = "+i._1 + " Columna: "+i._2 + " Resultado: "+resultado)
      resultado == 1
    }
    }
  }

  // generador coordenadas internas
  val coordenadasInteriores = for {
    fila <- Gen.choose(2, MAXIMO)
    columna <- Gen.choose(1, fila-1)
  } yield(fila, columna)

  property("Elementos interiores del triangulo: ") = {
    forAll(coordenadasInteriores) { (i) => {
      val resultado=TrianguloPascal.calcularValorTrianguloPascal(i._1, i._2)
      val supIzquierda=TrianguloPascal.calcularValorTrianguloPascal(i._1-1, i._2-1)
      val supDerecha=TrianguloPascal.calcularValorTrianguloPascal(i._1-1, i._2)
      println("Fila = "+i._1 + " Columna: "+i._2 + " Numero: "+resultado)

      resultado == (supDerecha + supIzquierda)
    }
    }
  }
}
