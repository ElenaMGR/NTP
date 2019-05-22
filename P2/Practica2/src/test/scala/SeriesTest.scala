import org.scalatest.FunSuite

class SeriesTest extends FunSuite {

  test("Comprobar función") {
    assert(SeriesRecurrente.SeriesGenerica(16,0,1,1,1) == SeriesRecurrente.Fibonacci(16) &&
      SeriesRecurrente.SeriesGenerica(16,0,1,1,1) == 987)
    println("Fibonacci(16) = " +987)

    assert(SeriesRecurrente.SeriesGenerica(24,2,1,1,1) == SeriesRecurrente.Lucas(24) &&
      SeriesRecurrente.SeriesGenerica(24,2,1,1,1) == 103682)
    println("Lucas(24) = " +103682)

    assert(SeriesRecurrente.SeriesGenerica(13,2,6,2,1) == SeriesRecurrente.Pell(13) &&
      SeriesRecurrente.SeriesGenerica(13,2,6,2,1) == 228486)
    println("Pell(13) = " +228486)

    assert(SeriesRecurrente.SeriesGenerica(20,2,2,2,1) == SeriesRecurrente.PellLucas(20) &&
      SeriesRecurrente.SeriesGenerica(20,2,2,2,1) == 45239074)
    println("PellLucas(20) = " +45239074)

    assert(SeriesRecurrente.SeriesGenerica(10,0,1,1,2) == SeriesRecurrente.Jacobsthal(10) &&
      SeriesRecurrente.SeriesGenerica(10,0,1,1,2) == 341)
    println("Jacobsthal(10) = " +341)
  }
}
