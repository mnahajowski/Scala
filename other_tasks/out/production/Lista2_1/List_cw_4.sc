// -= obcina poczatkowo czesc tablicy
// /= wybiera co 4 element


sealed trait BT[+A]
case object Empty extends BT[Nothing]
case class Node[+A](elem:A, left:BT[A], right:BT[A]) extends BT[A]

sealed trait Graphs[A]
case class Graph[A](succ :A=>List[A]) extends Graphs[A]

val tt: Node[Int] = Node(1,Node(2,Node(4,Empty,Empty),Empty),Node(3,Node(5,Empty, Node(6,Empty,Empty)),Empty))


def breadthBT[A](tree: BT[A]) = {
  def helper[A](nodeQueue: List[BT[A]]): List[A] = nodeQueue match {
    case Nil => Nil
    case Empty :: tail => helper(tail)
    case Node(value, leftSubtree, rightSubtree) :: tail =>  value :: helper(tail ::: List(leftSubtree, rightSubtree))
  }
  helper (List(tree))
}

breadthBT(tt)


val g = Graph((i: Int) => i match
{
  case 0 => List(3)
  case 1 => List(0,2,4)
  case 2 => List(1)
  case 3 => Nil
  case 4 => List(0,2)
  case n => throw new Exception("Graph g: node "+n+" doesn't exist")})


def depthSearch[A](g: Graph[A])(startNode: A) = {
  def search(visited: List[A])(toVisit: List[A]): List[A] = toVisit match {
    case Nil => Nil
    case h :: t =>
        if (visited contains h) search (visited) (t)
        else h :: search (h :: visited) ((g succ h) ::: t)
  }

  search(Nil)(List(startNode))
}

depthSearch(g)(4)

def internalPath[A](tree: BT[A]) = {
  def helper (node: BT[A], depth: Int): Int = node match {
    case Empty => 0
    case Node(_, leftSubtree, rightSubtree) => depth + helper(leftSubtree, depth + 1) + helper(rightSubtree, depth + 1)
  }
  helper(tree, 0)
}

internalPath(tt)

def externalPath[A] (tree: BT[A]) = {
  def helper (node: BT[A], depth: Int): Int = node match {
    case Empty => depth
    case Node(_, leftSubtree, rightSubtree) => helper(leftSubtree, depth + 1) +

  helper(rightSubtree, depth + 1)
  }
  helper(tree, 0)
}

externalPath(tt)

def mergesort[A](order:(A, A) => Boolean, list: List[A]): List[A] = {
  val partition = list.length / 2
  if (partition == 0) list
  else {
    def merge(list1: List[A], list2: List[A]): List[A] = (list1, list2) match {
      case(Nil, list2) => list2
      case(list1, Nil) => list1
      case(head1 :: tail1, head2 :: tail2) =>
    if (order(head1, head2)) head1::merge(tail1, list2)
    else head2 :: merge(list1, tail2)
    }
    val (left, right) = list.splitAt(partition)
    merge(mergesort(order, left), mergesort(order, right))
  }
}

def order (num1 : Int, num2: Int) : Boolean = {
  num1 <= num2
}
mergesort(order, List(1, 7, 3, 4, 5))