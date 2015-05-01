
import week4._
object nth {
  def nth[T](n: Int, xs:List[T] ): T =
  if (xs.isEmpty) throw new IndexOutOfBoundsException
    else if (n == 0) xs.head
    else nth(n - 1, xs.tail)                      //> nth: [T](n: Int, xs: week4.List[T])T
	val list = new Cons(1,new Cons(2, new Cons(3, new Nil)))
                                                  //> list  : week4.Cons[Int] = 1,2,3,over
  nth(2,list)                                     //> res0: Int = 3
	List(1,2)                                 //> res1: week4.Cons[Int] = 1,2,over
	List(2)                                   //> res2: week4.Cons[Int] = 2,over
}