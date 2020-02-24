//import org.scalameter.measure

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}
import scala.util.Random

object List9_2 {
  def List9_2(data: Array[Int], start: Int, end: Int): Array[Int] = {
    var min = data(start)
    var max = data(start)
    for (n <- start to end) {
      if (data(n) < min) min = data(n)
      if (data(n) > max) max = data(n)
    }
    Array(min, max)
  }
  def List9_2(data: Array[Int]): Array[Int] = List9_2(data, 0, data.length - 1)

  def List9_2MT(data: Array[Int], start: Int, end: Int): Array[Int] = {
    if (end - start < 500000) List9_2(data, start, end)
    else {
      val mid = (end - start) / 2;

      val result = for {
        left <- Future(List9_2MT(data, start, mid))
        right <- Future(List9_2MT(data, mid+1, end))
      } yield List9_2(left.concat(right))
      Await.result(result, 20.seconds)
    }
  }

  def time[R] (block: => R) : R = {
    val t0  = System.nanoTime()
    val result = block
    val t1 = System.nanoTime()
    println("Elapsed time: " + (t1 - t0) + " ns")
    result
  }
  def List9_2MT(data: Array[Int]): Array[Int] = List9_2MT(data, 0, data.length - 1)

  def main(args: Array[String]): Unit = {
    val array = Array.fill(20)(Random.nextInt(20))

    println(array.mkString(", "))
    println(List9_2(array).mkString(", "))
    println(List9_2MT(array).mkString(", "))

    val array_time = Array.fill(100000)(Random.nextInt())

    time { println(List9_2(array_time).mkString(", "))}
    time { println(List9_2MT(array_time).mkString(", "))}
    /*val time = measure(println(List9_2(array_time).mkString(", ")))
    println(s"quickSortMut: $time")
    val timeMT = measure(println(List9_2MT(array_time).mkString(", ")))
    println(s"quickSortMutMT: $timeMT")*/
  }
}