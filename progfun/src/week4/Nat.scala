package week4

abstract class Nat {
 def isZero: Boolean
 def predecessor: Nat
 def successor = new Succ(this)
 def +(that: Nat): Nat
 def -(that: Nat): Nat
}

object Zero extends Nat{
   def isZero = true
   def predecessor = throw new Error("0.predecessor")
   def +(that: Nat)= that
   def -(that: Nat) = 
}


class Succ(n: Nat) extends Nat{
  def isZero = false
  def predecessor = n
  
}