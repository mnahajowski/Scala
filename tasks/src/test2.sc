{
  {
    val x1 = 7.5
    val x = x1 + x1
    val y = 2
    x + x + {
      val x = 10.0
      x + y
    }

  } + 1.0
}

val k3 = (3+4, 2.0, 2 < 4)
k3._1
k3._3
k3 == (8-1, 2.0, 2==2)

val k2 = (3 + 4, (2.0, 2 < 4))
k2._1
k2._2
(k2._2)._1