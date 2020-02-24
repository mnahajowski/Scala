/*
abstract class Sequence[+A] {
  def append[B >: A](x: Sequence[B]): Sequence[B]
}


*/
//class GenericCellMut[T] (var x: T) {}
//class GenericCellMut[+T] (var x: T) {}

//class GenericCellMut[-T] (var x: T) {}

/*
abstract class Sequence[+A]
{
  def append(x: Sequence[A]): Sequence[A]
}*/

abstract class Sequence[+A]
{
  def append[B >: A](x: Sequence[B]): Sequence[B]
}
case class Box[+A](v: A) {
  def set[B >: A](a: B) : Box[B] = Box(a)
}
  /*
case class Box[+A](private val value: A) {

  //def set(a: A): Box[A] = Box(a)
  def set[B >: A](x : Box[B]) : Box[A]= {value = x}

}*/
sealed abstract class Animal
class Cat extends Animal
class Dog extends Animal

val catBox = new Box[Cat](new Cat())
val dog2 = new Dog
catBox.set(dog2)
catBox.set(5)
val animalBox: Box[Animal] = catBox // valid because `Cat <: Animal`
val dog = new Dog
animalBox.set(dog)