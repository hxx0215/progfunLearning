package week5

object week5ex {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val fruit = List("apples", "orange", "pears")   //> fruit  : List[String] = List(apples, orange, pears)
  def removeAt(n: Int, xs: List[String]) = (xs take n) ::: (xs drop n + 1)
                                                  //> removeAt: (n: Int, xs: List[String])List[String]
  removeAt(2, fruit)                              //> res0: List[String] = List(apples, orange)
  def flatten(xs: List[Any]): List[Any] = {
    def flat(y: Any): List[Any] = y match {
      case List() => List()
      case List(x) => List(y)
      case x :: xs => x :: flatten(xs)
      case x => List(x)
    }
    xs match {
      case List() => List()
      case List(x) => flat(x)
      case y :: ys => flat(y) ::: flatten(ys)
    }
  }                                               //> flatten: (xs: List[Any])List[Any]
  flatten(List(1,List(2,List(3,4))))              //> res1: List[Any] = List(1, 2, 3, 4)
  fruit.flatten                                   //> res2: List[Char] = List(a, p, p, l, e, s, o, r, a, n, g, e, p, e, a, r, s)
  flatten(List(1, 1, 2, List(3, List(5, 8))))     //> res3: List[Any] = List(1, 1, 2, 3, 5, 8)
  def squareList(xs:List[Int]):List[Int] = xs match{
   case Nil => xs
   case y::ys => y*y :: squareList(ys)
  }                                               //> squareList: (xs: List[Int])List[Int]
  def squareList1(xs:List[Int]):List[Int] =
  xs map (x => x*x)                               //> squareList1: (xs: List[Int])List[Int]
  def concat[T](xs: List[T],ys: List[T]):List[T] =
  (xs foldRight ys)(_::_)                         //> concat: [T](xs: List[T], ys: List[T])List[T]
  def mapFun[T,U](xs:List[T], f: T=>U):List[U] =
  (xs foldRight List[U]())(f(_)::_)               //> mapFun: [T, U](xs: List[T], f: T => U)List[U]
  def lengthFun[T](xs: List[T]):Int =
  (xs foldRight 0)((_,y)=>1+y)                    //> lengthFun: [T](xs: List[T])Int
  lengthFun(List(1,2,3,4,3))                      //> res4: Int = 5
}