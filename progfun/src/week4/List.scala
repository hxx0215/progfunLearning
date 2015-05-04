package week4

trait List[+T] {
def isEmpty: Boolean
def head: T
def tail:List[T]
def prepend [U>: T](elem: U): List[U] = new Cons(elem,this)
}
class Cons[T] (val head:T,val tail: List[T]) extends List[T]{
  def isEmpty = false
  override def toString = head+","+tail
}
object Nil extends List[Nothing]{
  def isEmpty = true
  def head = throw new NoSuchElementException("Nil.head")
  def tail = throw new NoSuchElementException("Nil.tail")
  override def toString = "over"
}

//object List{
//  def apply[T](x: T, y: T) = new Cons(x,new Cons(y, new Nil))
//  def apply[T]() = new Nil
//  def apply[T](x: T) = new Cons(x,new Nil)
//}
object test{
  val x: List[String] = Nil
  
}