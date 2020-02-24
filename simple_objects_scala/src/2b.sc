class Time(h: Int, m: Int) {

  require(0 <= h && h < 24, "h = "+h)
  require(0 <= m && m < 60, "m = "+m)
  private var minutesAfterMidnight = h * 60 + m

  def hour: Int = minutesAfterMidnight / 60

  def hour_=(newHour: Int) {
    require(0 <= newHour && newHour < 24)
    minutesAfterMidnight = minute + newHour * 60
  }

  def minute: Int = minutesAfterMidnight % 60

  def minute_=(newMinute: Int) {
    require(0 <=  newMinute && newMinute < 60)
    minutesAfterMidnight = hour + newMinute
  }

  def before(other: Time): Boolean =
    minutesAfterMidnight < other.minutesAfterMidnight
}