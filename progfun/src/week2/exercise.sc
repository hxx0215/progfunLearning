package week2
import math.abs
object exercise {
  def factorial(n: Int): Int = {
    def loop(acc: Int, n: Int): Int =
      if (n == 0) acc
      else loop(acc * n, n - 1)
    loop(1, n)
  }                                               //> factorial: (n: Int)Int
  factorial(5)                                    //> res0: Int = 120

  def sum(f: Int => Int, a: Int, b: Int) = {
    def loop(a: Int, acc: Int): Int =
      if (a > b) acc
      else loop(a + 1, acc + f(a))
    loop(a, 0)
  }                                               //> sum: (f: Int => Int, a: Int, b: Int)Int
  sum(x => x * x, 3, 5)                           //> res1: Int = 50

  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
    if (a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
  }                                               //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b:
                                                  //|  Int)Int
  def product(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b)
                                                  //> product: (f: Int => Int)(a: Int, b: Int)Int
  product(x => x)(3, 7)                           //> res2: Int = 2520

  def fact(n: Int) = {
    product(x => x)(1, n)
  }                                               //> fact: (n: Int)Int
  fact(5)                                         //> res3: Int = 120

  val tolerance = 0.0001                          //> tolerance  : Double = 1.0E-4
  def isCloseEnouph(x: Double, y: Double) = {
    abs((x - y) / x) / x < tolerance
  }                                               //> isCloseEnouph: (x: Double, y: Double)Boolean
  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double = {
      val next = f(guess)
      if (isCloseEnouph(guess, next)) next
      else
        iterate(next)
    }
    iterate(firstGuess)
  }                                               //> fixedPoint: (f: Double => Double)(firstGuess: Double)Double
  
  fixedPoint(x => 1 + x/2)(1)                     //> res4: Double = 1.999755859375
  def sqrt(x:Double) = fixedPoint(y => (y+ x/y)/2)(1)
                                                  //> sqrt: (x: Double)Double
	sqrt(4)                                   //> res5: Double = 2.000000000000002
}