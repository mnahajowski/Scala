import scala.collection.mutable
def copy[T](dest: mutable.Seq[T], src: mutable.Seq[T]): Unit = {
  require(dest.length >= src.length)
  var index = 0
  src.foreach(element => {
    dest.update(index, element)
    index += 1
  })
}

var p : collection.mutable.Seq[Int] = collection.mutable.Seq(5)
var q : collection.mutable.Seq[Int] = collection.mutable.Seq(11,7,8)
copy(q,p)
q
//p += 2



var t : collection.mutable.ArrayBuffer[Int] = collection.mutable.ArrayBuffer()
t += 2
t += 1
t

var s : collection.mutable.ArrayBuffer[Int] = collection.mutable.ArrayBuffer()
s += 3
s += 4
s += 5
s
copy(s,t)
s

//(ArrayBuffer)