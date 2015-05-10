package week5

object mergesort {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  def msort(xs: List[Int]): List[Int] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (x < y) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }
      val (fst, snd) = xs splitAt n
      merge(msort(fst), msort(snd))
    }
  }                                               //> msort: (xs: List[Int])List[Int]
  val num = List(2,5,3,-3,312,2)                  //> num  : List[Int] = List(2, 5, 3, -3, 312, 2)
  msort(num)                                      //> res0: List[Int] = List(-3, 2, 2, 3, 5, 312)
}