package week1

object session {
  1 + 2                                           //> res0: Int(3) = 3
  def abs(x: Double) = if (x > 0) x else -x       //> abs: (x: Double)Double
  def sqrt(x: Double) = {
    def sqrtIter(guess: Double): Double = if (isGoodEnough(guess)) guess
    else sqrtIter(improve(guess))
    def isGoodEnough(guess: Double) =
      abs(guess * guess - x) / x < 1e-6

    def improve(guess: Double) =
      (guess + x / guess) / 2

    sqrtIter(1.0)
  }                                               //> sqrt: (x: Double)Double
  sqrt(2)                                         //> res1: Double = 1.4142135623746899
  sqrt(4)                                         //> res2: Double = 2.0000000929222947
  sqrt(1e4)                                       //> res3: Double = 100.00000025490743
  sqrt(0.04)                                      //> res4: Double = 0.2000000000021489
  sqrt(3)                                         //> res5: Double = 1.7320508100147274
  val g: PartialFunction[List[Int],String] = {
  case Nil => "one"
  case x:: rest =>
  	rest match {
  	case Nil => "two"
  	}
  }                                               //> g  : PartialFunction[List[Int],String] = <function1>
  g.isDefinedAt(List(1,2,3))                      //> res6: Boolean = true
  g(List())                                       //> res7: String = one
}