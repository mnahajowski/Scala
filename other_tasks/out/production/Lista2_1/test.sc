import scala.collection.mutable.Seq
def copy[T](dest: Seq[T], src: Seq[T]): Unit = {
  require(src.length>dest.length)
  var i = 0
  src.foreach(a => {
    dest.update(i, a)
    i += 1
  })
}
class UnderflowException(msg:String) extends Exception(msg)
class Queue[T] private(private val queue:(List[T],List[T])) {
  def normalize(xs1:List[T], xs2:List[T]) =
    (xs1,xs2) match {
      case (Nil, xs2) => new Queue((xs2.reverse, Nil))
      case queue => new Queue(queue)
    }
  def enqueue(v:T) = {
    val (xs1,xs2) = queue
    normalize(xs1,v::xs2)
  }
  def dequeue() =
    queue match {
      case (_::xs1tail,xs2) => normalize(xs1tail,xs2)
      case queue => new Queue(queue)
    }
  def first() =
    queue match {
      case (x::_, _) => x
      case _ => throw new UnderflowException("first")
    }
  def isEmpty() = queue==(Nil,Nil)
}
object Queue {
  def apply[T](xs:T*) = new Queue[T](xs.toList,Nil)
  def empty[T] = new Queue[T](Nil,Nil)
}

