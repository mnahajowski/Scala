class Time( private var h : Int,  private var m : Int) {

  require(0 <= h && h < 24,"newHour = " + h)
  require(0 <= m && m < 60,"newMinute = " + m)

  def  hour :Int = h
  def hour_=(newHour : Int):Unit = {
    require(0 <= newHour && newHour < 24, "newHour = " + newHour)
    h = newHour
  }

  def minute : Int = m

  def minute_=(newMinute : Int):Unit = {
    require(0 <= newMinute && newMinute < 60, "newMinute = " + newMinute)
    m = newMinute
  }

  def before(other: Time) : Boolean = {
    h < other.h || (h == other.h && m < other.m)
  }
}

val g = new Time(5,15)
g.hour
g.minute
g.hour
