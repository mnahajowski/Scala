sealed trait lBT[+A]
case object LEmpty extends lBT[Nothing]
case class LNode[+A](elem:A, left:()=>lBT[A], right:()=>lBT[A]) extends lBT[A]



def lrepeat[A](k:Int, myList:LazyList[A]):LazyList[A] = {
  def repeatElement(element: A, reps:Int, rest:LazyList[A]):LazyList[A] =
    if (reps == 0) rest
    else repeatElement(element, reps - 1, element #:: rest)
  myList match {
    case LazyList() => LazyList()
    case head #:: tail => repeatElement(head, k, lrepeat(k,tail))
  }
}



def lrepeat2[A](k:Int)(stream:Stream[A]):Stream[A] = {
  def repeatElement(element: A, reps:Int, rest:Stream[A]):Stream[A] =
    if (reps == 0) rest
    else repeatElement(element, reps - 1, element #:: rest)
  stream match {
    case Stream.Empty => Stream.Empty
    case head #:: tail => repeatElement(head, k, lrepeat2(k)(tail))
  }
}

val xs = lrepeat(3,LazyList(1,2,3))
xs.force

def lrepeat[A](k:Int)(myList:LazyList[A]):LazyList[A] = {
  def helper(reps:Int, rest:LazyList[A]):LazyList[A] = (reps, rest) match {
    case (_, LazyList()) => LazyList()
    case (0, _ #:: tail) => helper(k, tail)
    case (_, head #:: _) => head #:: helper(reps - 1, rest)
  }
  helper(k, myList)
}


val lfib = {
  def fibgen(a: Int, b: Int):LazyList[Int] =
    a #:: fibgen(b, a + b)
  fibgen(1, 1)
}

lfib.take(10).toList



def IBreadth[A](tree: lBT[A]) = {
  def helper (queue: List[lBT[A]]): LazyList[A] = queue match {
    case Nil => LazyList()
    case LEmpty :: tail => helper(tail)
    case LNode(value, leftSubtree, rightSubtree):: tail => value #::
      helper(tail ::: List(leftSubtree(), rightSubtree()))
  }
  helper(List(tree))

}

def lTree(n: Int): lBT[Int] =
  LNode(n, () => lTree(2 * n), () => lTree(2 * n + 1))

IBreadth(lTree(2)).take(16).toList

//val tt:lBT[Int] = lTree(2)
/*
val tt = lTree(2)
val xd = IBreadth(tt)
xd.force*/

def swap[A](tab: Array[A])(i: Int)(j: Int) = {
  val aux = tab(i)
  tab(i) = tab(j)
  tab(j) = aux
}


def choose_pivot[A](tab: Array[A])(m: Int)(n: Int) =
  tab((m+n)/2)

def partition(tab: Array[Int])(l: Int)(r: Int) = {
  var i = l
  var j = r
  val pivot = choose_pivot(tab)(l)(r)
  while (i <= j) {
    while (tab(i) < pivot) i += 1
    while (pivot < tab(j)) j -= 1
    //println("jestem")
    if (i <= j) {
      swap(tab)(i)(j)
      i += 1
      j -= 1
    }
  }
  (i, j)
}

def quick(tab: Array[Int])(l: Int)(r: Int): Unit =
  if (l < r) {
  val (i, j) = partition(tab)(l)(r)
  if (j - l <  r - i) {
    //val _ = quick(tab)(l)(j)
    quick(tab)(l)(j)
    quick(tab)(i)(r)
  }
  else {
    //val _ = quick(tab)(i)(r)
    quick(tab)(i)(r)
    quick(tab)(l)(j)
  }
}

def quicksort(tab: Array[Int]) = quick(tab)(0)(tab.length - 1)

val myList = Array(7, 3, 1, 2)
quicksort(myList)
myList







