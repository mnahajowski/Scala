import scala.annotation.tailrec
/*
def checkIfSameOrAlike(list: List[String], segm : String, segm2 : String, total : Int): List[String] =
{

  def reverse(init: List[String], res: List[String]): List[String] = {
    if(init == Nil) res
    else  reverse(init.tail, init.head :: res)
  }
// wyrazenia regularne
  def compareTwo(xs: String, ys:String): Boolean = (xs, ys) match
  {
    case("", "") => return true
    case("", _) => true
    case (_, "") => true
    case(_, _) => if(xs.head == ys.head) compareTwo(xs.tail, ys.tail) else false
  }


  def check(list: List[String], segm:String, segm2 : String, total : Int): List[String] = {
    if (list == Nil || total == 0) Nil
    else if (compareTwo(list.head, segm) || compareTwo(list.head, segm2)) list.head :: checkIfSameOrAlike(list.tail, segm, segm2, total-1)
    else checkIfSameOrAlike(list.tail, segm, segm2, total)
  }

  def ile(sum : List[String], total : Int): List[String] = {
    if(list == Nil || total == 0) Nil
    else sum.head :: ile(sum.tail, total-1)
  }

  check(list,segm, segm2, total)
}

checkIfSameOrAlike(List("index0169","index0168202","index0168211","index0168210","index0169222","index0169224"), "index0168", "index0169", 2)

def checkIfSameOrAlikeTail(list: List[String], segm : String, segm2 : String, total : Int): List[String] =
{

  def reverse(init: List[String], res: List[String]): List[String] = {
   if(init == Nil) res
   else  reverse(init.tail, init.head :: res)
}

  def compareTwo(xs: String, ys:String): Boolean = (xs, ys) match
  {
    case("", "") => return true
    case("", _) => false
    case (_, "") => true
    case(_, _) => if(xs.head == ys.head) compareTwo(xs.tail, ys.tail) else false
  }

  def check2(list: List[String], segm:String, segm2: String, sum : List[String], total:Int): List[String] = {
    if (list == Nil) {
      ile(reverse(sum,List()), total)
    }
      //reverse(sum,List())
    else if (compareTwo(list.head, segm) || compareTwo(list.head, segm2))check2(list.tail, segm, segm2,list.head :: sum,total)
    else checkIfSameOrAlikeTail(list.tail, segm, segm2, total)
  }

  def ile(sum : List[String], total : Int): List[String] = {
    if(list == Nil || total == 0) Nil
    else sum.head :: ile(sum.tail, total-1)
  }

  check2(list,segm, segm2, Nil,total)
}

checkIfSameOrAlikeTail(List("index0169","index0168202","index0168211","index0168210","index0169222","index0169224"), "index0168", "index0169", 2)

*/
/*
def mergeLists[A](list1 : List[Int], list2 : List[Int], list3 : List[Int]) : List[Int] = {
  def mergeListsRec(finalList: List[Int], list1 : List[Int], list2 : List[Int], list3 : List[Int]) : List[Int] =
    finalList ::: list1 ::: list2 ::: list3
  mergeListsRec(List(), list1, list2, list3)

}

mergeLists(List(1,3,5,7,9), List(2,4,6,8,10), List(1,2,3))
mergeLists(List(), List(1,2,3,4,5), List(1,2,3))
mergeLists(List(1,2,3,4,5), List(5), List(1,2,3))


def find[A](list1 : List[String], word : String) : List[String] = {
  def find_help (finalList : List[String], list1 : List[String], word : String) : List[String] = {
    if(list1 == Nil) finalList
    else if(list1.head == word)
      find_help(list1.head :: finalList, list1.tail, word)
    else find_help(finalList, list1.tail, word)


  }
  find_help(List(), list1, word)
}
find(List("element1", "element2"), "element1")


def adding(list1: List[Int], list2 : List[Int]) : List[Int] = {

  @tailrec
  def adding2[A](list3 : List[Int], list4 : List[Int], finalList : List[Int]) : List[Int] = {
    if(list3 == Nil && list4 == Nil) finalList
    else if(list3 == Nil)  finalList ::: list4.tail
    else if(list4 == Nil)  finalList ::: list3.tail
    else adding2(list3.tail, list4.tail,  finalList ::: List(list3.head + list4.head))
  }
  adding2(list1, list2, List())
}

adding(List(1,2,3,4), List(1,2,3))

//find (List("index0169","inde
// x0168202","index0168211","index0168210","index0169222","index0169224"), "index0168")
*/


def sumProd(xs : List[Int]) : (Int, Int) = {
  xs match {
    case h::t => {
      val (s,p) = sumProd(t)
      (h+s, h*p)
    }
    case Nil => (0,1)
  }

}

sumProd(List(1,2,3,4))


/*
def sumProd2(xs : List[Int]) : (Int, Int) = {
  xs.foldLeft(0,1) {
    (acc, h) => (acc._1 + h, acc._2 * h)
  }
}
sumProd2(List(1,2,3,4))
*/

def checkIfSameOrAlike(list: List[String], segm : List[String], total : Int): List[String] =
{

  def reverse(init: List[String], res: List[String]): List[String] = {
    if(init == Nil) res
    else  reverse(init.tail, init.head :: res)
  }

  def compareTwo(xs: String, ys:String): Boolean = (xs, ys) match
  {
    case("", "") => return true
    case("", _) => true
    case (_, "") => true
    case(_, _) => if(xs.head == ys.head) compareTwo(xs.tail, ys.tail) else false
  }
  def looping(ab : String, segm : List[String]) : Boolean = {
    if(segm == Nil) return false
    else if (compareTwo(ab, segm.head)) return true
    else looping(ab, segm.tail)
  }


  def check(list: List[String], segm : List[String], total : Int): List[String] = {
    if (list == Nil || total == 0) Nil
    else if (looping(list.head, segm)) list.head :: checkIfSameOrAlike(list.tail, segm, total-1)
    else checkIfSameOrAlike(list.tail, segm, total)
  }

  def ile(sum : List[String], total : Int): List[String] = {
    if(list == Nil || total == 0) Nil
    else sum.head :: ile(sum.tail, total-1)
  }

  check(list,segm, total)
}

checkIfSameOrAlike(List("index0169","index0168202","index0168211","index0168210","index0169222","index0169224"), List("index0168", "index0169"), 2)

def checkIfSameOrAlikeTail(list: List[String], segm : List[String], total : Int): List[String] =
{

  def reverse(init: List[String], res: List[String]): List[String] = {
   if(init == Nil) res
   else  reverse(init.tail, init.head :: res)
}
  def looping(ab : String, segm : List[String]) : Boolean = {
    if(segm == Nil) return false
    else if (compareTwo(ab, segm.head)) return true
    else looping(ab, segm.tail)
  }

  def compareTwo(xs: String, ys:String): Boolean = (xs, ys) match
  {
    case("", "") => return true
    case("", _) => false
    case (_, "") => true
    case(_, _) => if(xs.head == ys.head) compareTwo(xs.tail, ys.tail) else false
  }

  def check2(list: List[String], segm:List[String], sum : List[String], total:Int): List[String] = {
    if (list == Nil) {
      ile(reverse(sum,List()), total)
    }
      //reverse(sum,List())
    else if (looping(list.head, segm))check2(list.tail, segm,list.head :: sum,total)
    else checkIfSameOrAlikeTail(list.tail, segm, total)
  }

  def ile(sum : List[String], total : Int): List[String] = {
    if(list == Nil || total == 0) Nil
    else sum.head :: ile(sum.tail, total-1)
  }

  check2(list,segm, Nil,total)
}

checkIfSameOrAlikeTail(List("index0169","index0168202","index0168211","index0168210","index0169222","index0169224"), List("index0168", "index0169"), 2)



def matchingLists[A](list1: List[A], list2: List[A], list3: List[A]): List[A] =
{
  (list1, list2, list3) match
  {
    case (Nil, Nil, Nil) => Nil
    case (Nil, Nil, h::t) => h :: matchingLists(Nil, Nil, t)
    case (Nil, h::t, _) => h :: matchingLists(Nil, t, list3)
    case (h::t, _, _) => h :: matchingLists(t, list2, list3)
  }
}


def matchingListsTail [A] (list0: List[A], list1: List[A], list2: List[A]): List[A] = {
  @tailrec
  def matchHelping [A] (list0: List[A], list1: List[A], list2: List[A], acc: List[A]): List[A] =
    (list0, list1, list2) match {
      case (Nil, Nil, Nil) => acc
      case (h::t, Nil, Nil) => matchHelping(Nil, Nil, Nil, h::t ::: acc)
      case (_, h::t, Nil) => matchHelping(list0, Nil, Nil, h::t ::: acc)
      case (_, _, h::t) => matchHelping(list0, list1, Nil, h::t ::: acc)
    }
  matchHelping(list0, list1, list2, List())
}

matchingLists(List(1,3,5,7,9), List(2,4,6,8,10), List(1,2,3))

/*
def insertionSort(origList: List[Int]) : List[Int] = {

  def insert : (Int, List[Int]) => List[Int] = {
    case (numb, List())          => List(numb)
    case (numb, (x :: xs)) =>
      if (numb < x) numb :: x :: xs
      else x :: insert(numb, xs)
  }

  def insertionSortPrime(xs: List[Int], lst: List[Int]) : List[Int] =
    xs match {
    case Nil => lst
    case x :: xs => insertionSortPrime(xs, insert(x, lst))
  }
  insertionSortPrime(origList, List())
}

insertionSort(List(1, 7, 3, 4, 5))*/
/*
def insertSort(order:(Int,Int) => Boolean, list:List[Int]) : List[Int] = {



  def insertionSortPrime(xs: List[Int], lst: List[Int]) : List[Int] = {
    xs match {
      case Nil => lst
      case x :: xsd => insertionSortPrime(xsd, insert(x, lst))

    }
  }
    def insert : (Int, List[Int]) => List[Int] = {
      case (numb, List())          => List(numb)
      case (numb, (x :: xs)) =>
        if (order(numb,x)) numb :: x :: xs
        else x :: insert(numb, xs)
    }

  insertionSortPrime(list, List())
}
def order (num1 : Int, num2: Int) : Boolean = {
  num1 <= num2
}
insertSort(order, List(1, 7, 3, 4, 5))*/