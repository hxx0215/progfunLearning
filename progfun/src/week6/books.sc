package week6

object books {
  case class Book(title: String, authors: List[String])

  val books = Set(
    Book(
      title = "Structure and Interpretation of Computer Programs",
      authors = List("Al", "har", "sussman")),
    Book(
      title = "Introduce",
      authors = List("Bird,Richard", "wa,Pil")),
    Book(
      title = "effective java",
      authors = List("bloch,joshua")),
    Book(
      title = "java puzzlers",
      authors = List("bloch,joshua", "gaf,neal")),
    Book(
      title = "programming in scala",
      authors = List("oder,martin", "spoon,lex", "venner,bil")))
                                                  //> books  : scala.collection.immutable.Set[week6.books.Book] = Set(Book(effecti
                                                  //| ve java,List(bloch,joshua)), Book(Structure and Interpretation of Computer P
                                                  //| rograms,List(Al, har, sussman)), Book(programming in scala,List(oder,martin,
                                                  //|  spoon,lex, venner,bil)), Book(Introduce,List(Bird,Richard, wa,Pil)), Book(j
                                                  //| ava puzzlers,List(bloch,joshua, gaf,neal)))
      for (b <- books;a<- b.authors if a startsWith "bloch,")
      yield b.title                               //> res0: scala.collection.immutable.Set[String] = Set(effective java, java puzz
                                                  //| lers)
      for {
      b1 <- books
      b2 <- books
      if b1 != b2
      a1<-b1.authors
      a2<-b2.authors
      if a1==a2
      }yield a1                                   //> res1: scala.collection.immutable.Set[String] = Set(bloch,joshua)
}