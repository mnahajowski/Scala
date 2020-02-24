/*
def listAppend[A](myList1 : List[A], myList2 : List[A]) : List[A] =
  if (myList1 == Nil) myList2
  else if (myList2 == Nil) myList1
  else if (myList1 != Nil && myList2 != Nil)
    myList1.head += myList2.head :: listAppend(myList1.tail, myList2.tail)

listAppend(List(1,2,3,4), List(1,2,3,4))
*/
def sqrList(list:List[Int]) :List[Int] =
  if(list == Nil) Nil else list.head * list.head :: sqrList(list.tail)

//
// listAppend(myList1.tail, myList2.tail)
sqrList(List(1,2,3,-4))

def replicate[A](x : A, n : Int) : List[A] =
  if (n <= 0) Nil else x :: replicate (x, n - 1)

replicate("bab", 3)

/**
 * Created by wyklad on 24.10.16.
 */
  def dzialanie(a:List[Int], b:List[Int]):List[Int] = {
    def aos(a:List[Int], b:List[Int], op:Boolean, res:List[Int]):List[Int] = {
      def change(a:Int, b:Int, op:Boolean, res:List[Int]):List[Int] = {
        if (op) res++List(a-b)
        else res++List(a+b)
      }
      (a, b) match {
        case (Nil, Nil) => res
        case (_, Nil) => aos(a.tail, Nil, !op, change(a.head, 0, op, res))
        case (Nil, _) => aos(Nil, b.tail, !op, change(0, b.head, op, res))
        case _ => aos(a.tail, b.tail, !op, change(a.head, b.head, op, res))
      }
    }
    aos(a, b, true, List())
  }


    println(dzialanie(List(2, 4, 5,1), List(4, 5, 6, 7,8)))
    println(dzialanie(List(), List()))
