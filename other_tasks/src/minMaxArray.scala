
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}
import scala.util.Random

object minMaxArray {
  def minMax(my_array: Array[Int], start: Int, end: Int): Array[Int] = {

    var min = my_array(start)
    var max = my_array(start)
    for (n <- start to end) {
      if (my_array(n) < min) min = my_array(n)
      if (my_array(n) > max) max = my_array(n)
    }
    Array(min, max)
  }
  def minMax(data: Array[Int]): Array[Int] = minMax(data, 0, data.length - 1)

  def minMaxparallel(my_array: Array[Int], start: Int, end: Int): Array[Int] = {
    //println(start + " tut " + end)
    if (end - start < 200000) minMax(my_array, start, end)
    else {
      val mid = (end - start) / 2;
      //println(start + " tut " + end)
      val result = for {
        left <- Future(minMaxparallel(my_array, start, mid))
        right <- Future(minMaxparallel(my_array, mid+1, end))
      } yield minMax(left.concat(right))
      Await.result(result, 10.seconds)
    }
  }

  def time[R] (time: => R) : R = {
    val start  = System.nanoTime()
    val result = time
    val end = System.nanoTime()
    println("Elapsed time: " + (end - start))
    result
  }

  def minMaxparallel(my_array: Array[Int]): Array[Int] = minMaxparallel(my_array, 0, my_array.length - 1)



  def main(args: Array[String]): Unit = {
    val array = Array.fill(20)(Random.nextInt(20))

    println(array.mkString(", "))
    println(minMax(array).mkString(", "))
    println(minMaxparallel(array).mkString(", "))

    time {minMax(array).mkString(", ")}
    time {minMaxparallel(array).mkString(", ")}

    val array_time = Array.fill(70000)(Random.nextInt(10000000))
    val array2_time = Array.fill(70000)(Random.nextInt(10000000))
    time {minMax(array_time).mkString(", ")}
    println(minMax(array_time).mkString(", "))
    time {minMaxparallel(array2_time).mkString(", ")}
    println(minMax(array2_time).mkString(", "))


  }
}