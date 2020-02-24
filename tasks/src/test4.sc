//1
def listiloczyn(xs :List[Double]) : Double =
  if(xs == Nil) 0
    else if(xs.tail == Nil) xs.head
  else xs.head * listiloczyn(xs.tail)

listiloczyn(List(1,2,3,4))
listiloczyn(List(2,3,4,5))
listiloczyn(List(1))

//3
def czyNieujemne(xs : List[Double]) : Boolean =
  if(xs == Nil) true
  else (if (xs.head >= 0) czyNieujemne(xs.tail) else false)

czyNieujemne(List(1,2,3,5))
czyNieujemne(List(1,2,3,-5))
czyNieujemne(List(1,2,3,0))

//2
def silnia(xs : Int) : Int =
  if(xs < 0) throw new Exception("zla liczba")
  else if(xs == 0) 1 else xs * silnia(xs-1)

silnia(5)
silnia(0)
silnia(2)
silnia(4)

//4




def lacznik4(xs : List[String], end : Char, sep : Char) : String =
  if(xs == Nil) ""
  else if(xs.tail == Nil) xs.head +  end.toString
  else xs.head + sep + lacznik4(xs.tail, end, sep)

lacznik4(List("test","proba", "zadanie"), '.', ';')
lacznik4(List("test","proba"), '!', '.')
lacznik4(List("proba","test"), '.', ';')
lacznik4(List(), '.', ';')