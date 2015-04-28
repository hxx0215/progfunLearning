package week3
class Rational(x: Int, y: Int) {
require(y!=0 , "denominator must be not zero")
def this(x: Int) = this(x,1)
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private val g = gcd(x, y)
  def numer = x / g
  def denom = y / g
  def <(that: Rational) = numer * that.denom < that.numer * denom
  def max(that: Rational) = if (this < (that)) that else this
  def + (that: Rational) =
    new Rational(
      numer * that.denom + denom * that.numer,
      denom * that.denom)

  override def toString = numer + "/" + denom
  def unary_- = new Rational(-numer, denom)
  def - (that: Rational) = this + -that
}