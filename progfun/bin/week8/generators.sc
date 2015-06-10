package week8

object generators {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  trait Generator[+T] {
    self =>
    def generate: T
    def foreach[U](f: T => U) {
      f(generate)
    }
    def map[S](f: T => S): Generator[S] = new Generator[S] {
      def generate = f(self.generate)
    }
    def flatMap[S](f: T => Generator[S]): Generator[S] = new Generator[S] {
      def generate = f(self.generate).generate
    }
  }
  val integers = new Generator[Int]{
  def generate = scala.util.Random.nextInt()
  }                                               //> integers  : week8.generators.Generator[Int] = week8.generators$$anonfun$main
                                                  //| $1$$anon$3@3498ed
}