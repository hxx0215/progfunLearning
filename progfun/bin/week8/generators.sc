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
                                                  //| $1$$anon$3@3d8c7aca
	val booleans = integers.map(_>0)          //> booleans  : week8.generators.Generator[Boolean] = week8.generators$$anonfun$
                                                  //| main$1$Generator$1$$anon$1@3fb6a447
	  trait Tree
  case class Inner(left: Tree, right: Tree) extends Tree
  case class Leaf(x: Int) extends Tree
	def leafs:Generator[Leaf] = for{
	 x<- integers
	} yield Leaf(x)                           //> leafs: => week8.generators.Generator[week8.generators.Leaf]
	def inners: Generator[Inner] = for{
	l <- trees
	r <- trees
	}yield Inner(l,r)                         //> inners: => week8.generators.Generator[week8.generators.Inner]
	def trees: Generator[Tree] = for{
	isLeaf <- booleans
	tree <- if (isLeaf) leafs else inners
	}yield tree                               //> trees: => week8.generators.Generator[week8.generators.Tree]
}