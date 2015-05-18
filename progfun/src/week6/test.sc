package week6

object test {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val xs = Array(1, 2, 3, 44)                     //> xs  : Array[Int] = Array(1, 2, 3, 44)
  xs map (x => x * 2)                             //> res0: Array[Int] = Array(2, 4, 6, 88)
  val s = "Hello World"                           //> s  : String = Hello World
  s filter (_.isUpper)                            //> res1: String = HW
  s exists (_.isUpper)                            //> res2: Boolean = true
  val pairs = List(1, 2, 5) zip s                 //> pairs  : List[(Int, Char)] = List((1,H), (2,e), (5,l))
  pairs.unzip                                     //> res3: (List[Int], List[Char]) = (List(1, 2, 5),List(H, e, l))
  s flatMap (c => List('.', c))                   //> res4: String = .H.e.l.l.o. .W.o.r.l.d
  def isPrime(n: Int): Boolean = (2 until n ) exists (d => n % d == 0)
                                                  //> isPrime: (n: Int)Boolean

  isPrime(3)                                      //> res5: Boolean = false
  isPrime(4)                                      //> res6: Boolean = true
  isPrime(9)                                      //> res7: Boolean = true
  isPrime(5)                                      //> res8: Boolean = false
}