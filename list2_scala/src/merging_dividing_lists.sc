
def listReversing[A] (myList : List[A]) : List[A] = {

  if(myList == Nil) Nil
  else listReversing(myList.tail) :+  myList.head
}

listReversing(List(1,2,3,4))

def mergeLists[A](list1 : List[A], list2 : List[A]) : List[A] = {
  def mergeListsRec(finalList: List[A], list1 : List[A], list2 : List[A]) : List[A] =
    if(list1 == Nil) finalList ::: list2
    else if (list2 == Nil) finalList ::: list1
  else mergeListsRec(finalList ::: List(list1.head) ::: List(list2.head), list1.tail, list2.tail)
  mergeListsRec(List(), list1, list2)

}

mergeLists(List(1,3,5,7,9), List(2,4,6,8,10))


def divideLists(xs:List[Int]) : (List[Int] , List[Int]) =
{
  if(xs.isEmpty) (Nil,Nil)
  else if(xs.head < 0 ) (xs.head::divideLists(xs.tail)._1,
    if(xs.head % 2 == 0) divideLists(xs.tail)._2 else xs.head::divideLists(xs.tail)._2)
  else divideLists(xs.tail)
}

divideLists(List(-3, -6, 8, -9, 13))

def divideLists3(xs:List[Int]) : (List[Int], List[Int]) = {
  def divideLists2Rec(finalList: List[Int], list1 : List[Int], list2 : List[Int], number : Int) : (List[Int], List[Int]) = {
    if (finalList == Nil) (Nil,Nil)
    else if (number %2 == 0)
      divideLists2Rec(finalList.tail, list1 ::: List(finalList.head), list2, number + 1)
    else
      divideLists2Rec(finalList.tail, list1, list2  ::: List(finalList.head), number + 1)
  }

  divideLists2Rec(xs, List(), List(), 1)
}


def divideLists2(xs:List[Int]) : (List[Int], List[Int]) = {
  def divideLists3Rec(finalList: List[Int], list1 : List[Int], list2 : List[Int], number : Int) : (List[Int], List[Int]) = {
    if (finalList == Nil) (list1, list2)
    else if (number %2 == 0)
      divideLists3Rec(finalList.tail, list1 ::: List(finalList.head), list2, number + 1)
    else
      divideLists3Rec(finalList.tail, list1, list2  ::: List(finalList.head), number + 1)
  }

  divideLists3Rec(xs, List(), List(), 1)
}
divideLists2(List(1,2,3,4,5,6,7,8))


