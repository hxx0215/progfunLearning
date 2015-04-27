package week3

object intsets {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val t1 = new NonEmpty(3, new Empty,new Empty)   //> t1  : week3.NonEmpty = {.3.}
  val t2 = t1 incl 4                              //> t2  : week3.Intset = {.3{.4.}}
}

abstract class Intset {
  def incl(x: Int): Intset
  def contains(x: Int): Boolean
  def union(other: Intset):Intset
}

class NonEmpty(elem: Int, left: Intset, right: Intset) extends Intset {
  def contains(x: Int) = if (x < elem) left contains x
  else if (x > elem) right contains x
  else true
  def incl(x: Int) = if (x < elem) new NonEmpty(elem, left incl x, right)
  else if (x > elem) new NonEmpty(elem, left, right incl x)
  else this
  override def toString = "{"+ left +elem + right + "}"
  def union(other: Intset) = ((left union right) union other) incl elem
}

class Empty extends Intset {
  def contains(x: Int) = false
  def incl(x: Int) = new NonEmpty(x, new Empty,new Empty)
  override def toString = "."
  def union(other: Intset) = other
}