/*class Para[T](val first : T, val second : T) {
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