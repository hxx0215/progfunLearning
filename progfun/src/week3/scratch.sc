import week3.Rational

object scratch {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  new Rational(1,2)                               //> res0: week3.Rational = 1/2
  def error(msg :String) = throw new Error(msg)   //> error: (msg: String)Nothing
}