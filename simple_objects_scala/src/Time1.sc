class Time (var hours:Int){
  private[this] var h = hours
  if (h < 0) h = 0

  def hour: Int = h

  def hour_=(newHour : Int) : Unit  = {
    if (newHour < 0) h = 0
    else h = newHour
  }
}

object Time {
  def apply(myHour : Int) = new Time(myHour)
}

val g = new Time(5)
val h = new Time(-5)
h.hour
g.hour
g.hour = 10
g.hour



val t = Time(15)
t.hour