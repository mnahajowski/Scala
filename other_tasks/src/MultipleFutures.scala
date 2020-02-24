import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

object MultipleFutures extends App {

  val startTime = getTime

  println(s"creating f1:  $delta")
  val f1 = slowlyDouble(x=1, delay=1500, name="f1")

  Thread.sleep(100)
  println(s"\ncreating f2:  $delta")
  val f2 = slowlyDouble(x=2, delay=250, name="f2")

  Thread.sleep(100)
  println(s"\ncreating f3:  $delta")
  val f3 = slowlyDouble(x=3, delay=500, name="f3")

  println(s"\nentering `for`: $delta")
  val result = for {
    r1 <- f1
    r2 <- f2
    r3 <- f3
  } yield (r1 + r2 + r3)

  println("\nBEFORE onComplete")
  result.onComplete {
    case Success(x) => {
      println(s"\nresult = $x (delta = $delta)")
    }
    case Failure(e) => e.printStackTrace
  }
  println("AFTER onComplete\n")
  sleep(1500)

  def slowlyDouble(x: Int, delay: Int, name: String): Future[Int] = Future {
    println(s"entered $name:  $delta")
    sleep(delay)
    println(s"leaving $name:  $delta")
    x
  }

  def delta = System.currentTimeMillis - startTime
  def getTime = System.currentTimeMillis
  def sleep(time: Long): Unit = Thread.sleep(time)

}