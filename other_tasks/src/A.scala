
class A {
  protected var x = 0
  def get= x
  def incr: this.type  = {x += 1; this}
}
// this.type}
class B extends A {
  def decr: this.type = {x -= 1; this}
}
object Para2 {
  def main(args: Array[String]): Unit = {
    val b = new B
    b.incr
    System.out.println(b.get)
    val a = new A
    a.incr.get
    System.out.println(a.get)
  }
}