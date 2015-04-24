package week3

object exercise {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val x = new Rational(1, 3)                      //> x  : week3.Rational = 1/3
  x.numer                                         //> res0: Int = 1
  x.denom                                         //> res1: Int = 3
  val y = new Rational(5, 7)                      //> y  : week3.Rational = 5/7
  x.add(y)                                        //> res2: week3.Rational = 22/21
  val z = new Rational(3,2)                       //> z  : week3.Rational = 3/2
  x.sub(y).sub(z)                                 //> res3: week3.Rational = -79/42
}

class Rational(x: Int, y: Int) {
  def numer = x
  def denom = y

  def add(that: Rational) =
    new Rational(
      numer * that.denom + denom * that.numer,
      denom * that.denom)

  override def toString = numer + "/" + denom
	def neg = new Rational(- numer,denom)
	def sub(that: Rational) = add(that.neg)
}