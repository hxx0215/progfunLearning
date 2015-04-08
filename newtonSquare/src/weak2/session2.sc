package weak2

object session2 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  def product(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 1
    else f(a) * product(f)(a + 1, b)
  }                                               //> product: (f: Int => Int)(a: Int, b: Int)Int
  product(x => x * x)(3, 7)                       //> res0: Int = 6350400

  def fact(n: Int): Int = {
    if (n == 0) 1
    else product(x => x)(1, n)
  }                                               //> fact: (n: Int)Int
  fact(3)                                         //> res1: Int = 6
  fact(5)                                         //> res2: Int = 120

  def sumproduct(f: Int => Int)(g: (Int, Int) => Int)(a: Int, b: Int, zero: Int): Int = {
    if (a > b) zero
    else g(f(a), sumproduct(f)(g)(a + 1, b, zero))
  }                                               //> sumproduct: (f: Int => Int)(g: (Int, Int) => Int)(a: Int, b: Int, zero: Int)
                                                  //| Int

  def pro(f: Int => Int)(a: Int, b: Int): Int = sumproduct(f)((x, y) => x * y)(a, b, 1)
                                                  //> pro: (f: Int => Int)(a: Int, b: Int)Int
  pro(x =>x *x)(3,7)                              //> res3: Int = 6350400
}