import scala.collection.mutable.ArrayBuffer
trait Debug {

  def debugName() = "Klasa " + getClass.toString.substring(getClass.toString.lastIndexOf('$') + 1)
 // def debugName() = getClass.
  def debugVars(): Array[String] = {
    val tab = ArrayBuffer.empty[String]
    val vars = this.getClass.getDeclaredFields()

    for (v <- vars) {
      v.setAccessible(true)
      tab += ("Pole: " + v.getName() + " => " + v.getType() + "," + v.get(this))
    }
    tab.toArray
  }

  def f(c: Boolean)(e: =>Unit) { if (c) {e; f(c)(e)}}

}

class Point(xv: Int, yv: Int) extends Debug {
  var x: Int = xv
  var y: Int = yv
  var a: String = "test"
}
object List8 {
  def main(args: Array[String]): Unit = {
    var p : Point = new Point(3,4);
    var s = p.debugName();
    println(s)

    var vars = p.debugVars()

    for(v <- vars) {
      println(v)
    }

    var i = 0
    p.f(i < 5) {print(i + " "); i += 2}
  }
}





