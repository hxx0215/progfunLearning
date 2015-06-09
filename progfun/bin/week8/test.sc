package week8

object test {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val f: PartialFunction[String , String] = {case "ping" => "pong"}
                                                  //> f  : PartialFunction[String,String] = <function1>
  f("ping")                                       //> res0: String = pong
  f.isDefinedAt("abc")                            //> res1: Boolean = false
  val N= 10                                       //> N  : Int = 10
  for {
  x<- 2 to N
  y<- 2 to x
  if (x % y == 0)
  }yield (x,y)                                    //> res2: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,2), (3,3
                                                  //| ), (4,2), (4,4), (5,5), (6,2), (6,3), (6,6), (7,7), (8,2), (8,4), (8,8), (9,
                                                  //| 3), (9,9), (10,2), (10,5), (10,10))
}