
  import java.util.concurrent._
  import scala.util.DynamicVariable

  val pool = new ForkJoinPool

  class task_scheduler {

    def schedule[T] (body : => T) : ForkJoinTask[T] = {

      val task = new RecursiveTask[T] { def compute = body}

      if(Thread.currentThread.isInstanceOf[ForkJoinWorkerThread])
        task.fork()
      else pool.execute(task)
      task
    }
  }

  val scheduler = new DynamicVariable[task_scheduler](new task_scheduler)

  def task[T](body : => T) : ForkJoinTask[T] = { scheduler.value.schedule(body)}

  def parallel[A, B](task_a: => A, task_b: => B) : (A,B) = {
    val right = task {task_b}
    val left = task_a
    (left, right.join())
  }

  val double = (x : Int) => 2 * x

  def double_list_count (xs : List[Int]) : List[Int] =
    if(xs.length > 0) List(double(xs.head)) ::: double_list_count(xs.tail)
    else Nil

  def parallel_double_list_count (xs : List[Int]) : List[Int] =
    if(xs.length > 0) {
      val(left,right) = parallel(List(double(xs.head)), parallel_double_list_count(xs.tail))
      left:::right
    }
    else Nil

  def time[R] (time: => R) : R = {
    val start  = System.nanoTime()
    val result = time
    val end = System.nanoTime()
    println("Elapsed time: " + (end - start))
    result
  }

  time{parallel_double_list_count(List(1,2,3,4,5,6,7,8,9,10));}
  time {double_list_count(List(1,2,3,4,5,6,7,8,9,10));}





