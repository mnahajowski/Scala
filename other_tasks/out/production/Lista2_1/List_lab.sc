def parallel[A, B] (takA: => A, taskB: => B): (A,B) = {
  val right = task{
    taskB
  }
  val left = taskA(left,right.join())
}