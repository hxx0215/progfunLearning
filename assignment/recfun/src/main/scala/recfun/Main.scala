package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = if (r==c) 1
  else if (c==0) 1
  else pascal(c-1,r-1) + pascal(c,r-1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def bal(stack:Int,ch:List[Char]): Boolean={
      if (ch.isEmpty)
        stack==0
        else
      if (stack<0) false
      else
      {
        if (ch.head == '(') bal(stack+1,ch.tail)
        else if (ch.head == ')') bal(stack-1,ch.tail)
        else bal(stack,ch.tail)
      }
    }
    bal(0,chars)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) 1
    else if (money < 0) 0
    else if (coins.isEmpty) 0
    else countChange(money,coins.tail)+countChange(money-coins.head,coins)
  }
}
