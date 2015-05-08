package week5

object week5ex {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val fruit = List("apples","orange","pears")     //> fruit  : List[String] = List(apples, orange, pears)
  def removeAt(n: Int,xs: List[String]) = (xs take n):::(xs drop n+1)
                                                  //> removeAt: (n: Int, xs: List[String])List[String]
  removeAt(2,fruit)                               //> res0: List[String] = List(apples, orange)
}