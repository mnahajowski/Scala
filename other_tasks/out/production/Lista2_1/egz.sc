def f(list:Any):Boolean = {
  list match{
    case a::b::Nil => true
    case _ => false
  }
}
f(1)
f(List(1,2))
//f(1::2)
f(1::2::3::Nil)
(1::2::3::Nil)
f(List(1,2,3))
List(1,2,3)
f((1::Nil::(2::Nil::Nil)::Nil))
(1::Nil::(2::Nil::Nil)::Nil)
f((1::Nil::(2::Nil::Nil)))
(1::Nil::(2::Nil::Nil))
(1::Nil::2::Nil::Nil)

def g(list:Any):Boolean = {
  list match{
    case (a::b)::Nil => true
    case _ => false
  }
}

g((1::2::Nil)::(2::Nil)::Nil::Nil)
(1::2::Nil)::(2::Nil)::Nil::Nil

g((1::2::Nil)::Nil) // true List(List(1, 2))
(1::2::Nil)::Nil

g(List(1::2::Nil)) // true List(List(1, 2))
List(1::2::Nil)

g((1::Nil)::Nil) // true List(List(1, 2))
(1::Nil)::Nil

g(List()::Nil) // true List(List(1, 2))
List()::Nil

def h(list:Any):Boolean = {
  list match{
    case (a::b)::c => true
    case _ => false
  }
}
((1::Nil::(2::Nil::Nil)))
h(List(1,2,3)::List(3,4,5))
h((1::2::Nil)::Nil)
h(List(1::2::Nil))
h(((1,2,3)::(3,4,5)::Nil)::((1,2)::Nil)::Nil)
(((1,2,3)::(3,4,5)::Nil)::((1,2)::Nil)::Nil)
h(1::2::3::Nil)//false
(1::2::3::Nil)
h((1::Nil)::(2::Nil)::Nil)//
h(List(1,2)::Nil)
h(List(1,2,3)::Nil)
(1::Nil)::(2::Nil)::Nil
h((1::Nil)::(2::Nil)::Nil::Nil)//
(1::Nil)::(2::Nil)::Nil::Nil



/*def f(c: => Boolean)(e: Unit) { if (c) {e; f(c)(e)}}
var i = 0
f(i < 5) {print(i + " "); i += 2}*/