// 4

def sqrList(list:List[Int]) :List[Int] =
  if(list == Nil) Nil else list.head * list.head :: sqrList(list.tail)

sqrList(List(1,2,3,-4))




val a = "la"
val b = 3
//3
def replicate[A](x : A, n : Int) : List[A] =
  if (n <= 0) Nil else x :: replicate (x, n - 1)

replicate("bab", 3)

//6
def listLength[A](xs : List[A]) : Int =
  if(xs == Nil) 0 else 1 + listLength(xs.tail)

listLength(List(1,2,3,4,5,6))

// 2

def count[A](x : A, xs : List[A]) : Int =
  if (xs == Nil) 0 else (if (xs.head == x) 1 else 0) + count(x, xs.tail)

count(5, List(5,2,5,6,14,2,5))

//1

def flatten[A](xss: List[List[A]]) : List[A] =
  if(xss == Nil) Nil else xss.head ::: flatten(xss.tail)

flatten(List(List(5,6),List(1,2,3)))

//5
//

def palindrome[A](xs: List[A]) : Boolean =
  if(xs.reverse == xs) true else false

palindrome(List(5,6,5))



def lacznik(xs : List[String]) : String =
  if(xs == Nil) ""  else xs.head + lacznik(xs.tail)



def sqrList(xs :List[Int]) : List[Int] =
  if (xs == Nil) Nil else xs.head * xs.head :: sqrList(xs.tail)

sqrList(List(1,2,3,4))

def replicate [A](word : A, number : Int) : List[A] =
  if(number < 0) throw new Exception("zla liczba")
  else if(number == 0) Nil else word :: replicate(word, number-1)

def palindrom [A](word : List[A]) : Boolean =
  word.reverse == word

def listLength[A](word : List[A]) : Int =
  if(word == Nil) 0 else 1 + listLength(word.tail)


lacznik(List("test", ";" , "elo"))

def lacznik2(xs : List[String], end : Char, sep : Char) : String =
  if(xs == Nil) end.toString
  else if(xs.tail == Nil) xs.head
  else xs.head + sep + lacznik2(xs.tail, end, sep)

lacznik2(List("test","proba"), '.', ';')
lacznik2(List("test","proba"), '!', '.')
lacznik2(List("proba","test"), '.', ';')