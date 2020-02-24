import scala.annotation.tailrec

def fibon (number : Int) : Int =
  number match {
    case 0 => 0
    case 1 => 1
    case _ => fibon(number-2)+fibon(number-1)
  }

//fibon(42)

def fibon2(number : Int) :Int = {
  @tailrec
  def fibon3(number: Int, score1: Int, score2: Int): Int =
    number match {
      case 0 => score1
      case 1 => score2
      case _ => fibon3(number - 1, score2, score1 + score2)
    }

  fibon3(number, 0, 1)
}

fibon2(42)

//3

def root3 (a : Double) : Double = {
  @tailrec
  def root3_iter(score : Double) : Double =
    if(math.abs(Math.pow(score, 3) - a) <= 1.0E-15 * Math.abs(a)) score
    else root3_iter(score + (a / Math.pow(score, 2) - score) / 3)
  root3_iter(if (a>1) a/3 else a)
}

root3(15)

//6

def replaceNth[A](xs : List[A], n : Int, a : A) : List[A] = {
  case (Nil, _) => Nil
  case (head :: tail, 0) => a :: tail
  case (head :: tail, _) => head :: replaceNth(tail, n - 1, a)
}

//5

def initSegment[A](firstList : List[A], secondList : List[A]) :Boolean =
  (firstList, secondList) match {
    case (Nil, _) => true
    case (_, Nil) => false
    case _ =>
      if(firstList.head == secondList.head) initSegment(firstList.tail, secondList.tail)
      else false
  }


def divideLists(xs:List[Int]) : (List[Int] , List[Int]) =
{
  if(xs.isEmpty) (Nil,Nil)
  else if(xs.head < 0 ) (xs.head::divideLists(xs.tail)._1,
    if(xs.head % 2 == 0) divideLists(xs.tail)._2 else xs.head::divideLists(xs.tail)._2)
  else divideLists(xs.tail)
}

divideLists(List(-3, -6, 8, -9, 13))


def matchTwoLists(xs:List[Int], ls: List[Int]): List[Int] = {
  (xs, ls) match {
    case (Nil, Nil) => Nil
    case (head :: tail, Nil) => head :: matchTwoLists(tail, Nil)
    case (Nil, head1 :: tail1) => head1 :: matchTwoLists(Nil, tail1)
    case (head :: tail, head1 :: tail1) => head :: head1 :: matchTwoLists(tail, tail1)
  }
}