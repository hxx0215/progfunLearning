package weak1

object session {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  def sqrtIter(guess: Double,x: Double):Double={
  if (goodEnough(guess, x)) guess
  else sqrtIter(improve(guess,x),x)
  }                                               //> sqrtIter: (guess: Double, x: Double)Double
  def goodEnough(guess: Double,x: Double)={
  	(abs(x-guess*guess) / x <0.0001)
  }                                               //> goodEnough: (guess: Double, x: Double)Boolean
  def abs(x: Double)={
  	if (x>0) x
  	else -x
  }                                               //> abs: (x: Double)Double
  def improve(guess: Double, x: Double) = {
  	(guess + x / guess) / 2
  }                                               //> improve: (guess: Double, x: Double)Double
  def sqrt(x: Double):Double = sqrtIter(1,x)      //> sqrt: (x: Double)Double
  sqrt(2)                                         //> res0: Double = 1.4142156862745097
  sqrt(0.001)                                     //> res1: Double = 0.03162278245070105
  sqrt(1e-20)                                     //> res2: Double = 1.0000021484861236E-10
  def fact(n: Int):Int =
  if (n==0) 1 else n*fact(n-1)                    //> fact: (n: Int)Int
  def fa(n: Int):Int = {
  def fac(n:Int, m:Int):Int = {
  if (n==0) m
  else fac(n-1,m * n)
  }
  fac(n,1)
  }                                               //> fa: (n: Int)Int
  fact(4)                                         //> res3: Int = 24
  fa(4)                                           //> res4: Int = 24
  fa(5)                                           //> res5: Int = 120
  fa(10)                                          //> res6: Int = 3628800
  
  
}