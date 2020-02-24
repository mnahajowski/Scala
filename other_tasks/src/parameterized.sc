/*class Parameterized[T](val transform: T=>T, val initial: T)  {

  var current = initial
}
val p = new Parameterized[String]((x)=>x+x, "hi! ")
p.initial
p.current= p.transform(p.initial)
p.current

class Para[T](val first : T, val second : T) {
  var fst = first;
  var snd = second

  def frs : T = fst
  def sec : T = snd

  def frs_= (newFst : T) {
    fst = newFst
  }

  def sec_= (newSnd : T): Unit = {
    snd = newSnd
  }
  override def toString: String = {
    "(" + fst.toString() + ", " + snd.toString + ")"
  }
}

val p1 = new Para[Int](5,7)
p1.toString
p1.frs=2
p1.toString*/

trait AbstractPara {
  type T
  var fst : T
  var snd : T
  def frs_=(newFst : T) : Unit
  def sec_=(newSnd : T) : Unit
  def frs : T
  def sec : T
  def toString : String
}

val c = new AbstractPara {
  type T = Int;
  def frs = fst;
  def frs_=(newFst : T) : Unit=
    fst = newFst;

  def sec = snd;
  def sec_=(newSnd : T) =
    snd = newSnd;

  var fst = 5
  var snd = 7
  override def toString() : String = "(" + fst.toString() + ", " + snd.toString + ")"
}

c.toString
c.frs=2
c.toString()


/*class A {
  protected var x = 0
  def get= x
  def incr: this.type  = {x += 1; this}
}
// this.type}
class B extends A {
  def decr: this.type = {x -= 1; this}
}

  val b = new B
  b.incr
  val a = new A
  a.incr.get*/

