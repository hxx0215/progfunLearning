package week5

object listfun {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val nums = List(2, -4 ,5, 7 ,1)                 //> nums  : List[Int] = List(2, -4, 5, 7, 1)
  nums filter (x => x>0)                          //> res0: List[Int] = List(2, 5, 7, 1)
  nums filterNot(x=>x>0)                          //> res1: List[Int] = List(-4)
  nums partition(x=>x>0)                          //> res2: (List[Int], List[Int]) = (List(2, 5, 7, 1),List(-4))
  nums takeWhile(x=>x>0)                          //> res3: List[Int] = List(2)
  nums dropWhile(x=>x>0)                          //> res4: List[Int] = List(-4, 5, 7, 1)
  nums span(x=>x>0)                               //> res5: (List[Int], List[Int]) = (List(2),List(-4, 5, 7, 1))
  
  def pack[T](xs:List[T]):List[List[T]] = xs match{
   case Nil => Nil
   case x::xs1 =>
    val (first,rest) = xs span (y => y==x)
    first :: pack(rest)
  }                                               //> pack: [T](xs: List[T])List[List[T]]
  val data = List("a","a","a","b","c","c","a")    //> data  : List[String] = List(a, a, a, b, c, c, a)
  pack(data)                                      //> res6: List[List[String]] = List(List(a, a, a), List(b), List(c, c), List(a))
                                                  //| 
  
  def encode[T](xs: List[T]):List[(T,Int)] =
  pack(xs) map(ys =>(ys.head,ys.length))          //> encode: [T](xs: List[T])List[(T, Int)]
                                        
	encode(data)                              //> res7: List[(String, Int)] = List((a,3), (b,1), (c,2), (a,1))
	val t = List(1,2,3,4,5)                   //> t  : List[Int] = List(1, 2, 3, 4, 5)
	t flatMap (n => List(n,n+1))              //> res8: List[Int] = List(1, 2, 2, 3, 3, 4, 4, 5, 5, 6)
	val a = t map (n=>List(n,n+1))            //> a  : List[List[Int]] = List(List(1, 2), List(2, 3), List(3, 4), List(4, 5), 
                                                  //| List(5, 6))
	a.flatten                                 //> res9: List[Int] = List(1, 2, 2, 3, 3, 4, 4, 5, 5, 6)
	val b = List(1,List(2,List(3)),4)         //> b  : List[Any] = List(1, List(2, List(3)), 4)
	
}