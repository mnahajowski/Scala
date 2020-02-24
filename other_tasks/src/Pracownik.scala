case class Pracownik(private var nazwisko : String = "Kowalski", private var zwolniony : Boolean = false) {
  import Pracownik._

  incr
  def nazw : String = nazwisko
  def nazw_=(newNazwisko : String)= {
    nazwisko = newNazwisko
  }

  def zwoln : Boolean = zwolniony
  def zwoln_=(newStatus : Boolean) = {
    zwolniony = newStatus
  }

  def liczbaPracownikow : Int  = number


  def zwolnij(): Unit = {
    this.zwoln = true
    decr
  }

  override def toString() : String = {
    this.nazw + " " + this.zwoln
  }

}
object Pracownik {
  private var liczba = 0
  def number : Int = liczba
  private def incr: this.type= {liczba += 1; this}
  private def decr: this.type= {liczba -= 1; this}
}

object List13 {
  def main(args: Array[String]): Unit = {

    val p = new Pracownik()
    System.out.println(p.toString())
    System.out.println(p.liczbaPracownikow)
    //System.out.println(p2.liczbaPracownikow)
    val p2 = new Pracownik()
    System.out.println(p.liczbaPracownikow)
    System.out.println(p2.liczbaPracownikow)
    p2.zwolnij()
    System.out.println(p2.toString())
    System.out.println(p.liczbaPracownikow)
    System.out.println(p2.liczbaPracownikow)

  }
}

/*import akka.actor.{ Actor, ActorRef, ActorSystem, PoisonPill, Props }

case object Ping
case object Pong

class Player(player2: ActorRef) extends Actor {
  var countDown = 10

  def receive = {
    case Ping =>
      println(s"${self.path} ping, counter $countDown")

      if (countDown > 0) {
        countDown -= 1
        player2 ! Pong
      } else {
        sender() ! PoisonPill
        self ! PoisonPill
      }
    case Pong =>
      println(s"${self.path} pong, counter $countDown")

      if (countDown > 0) {
        countDown -= 1
        sender() ! Ping
      } else {
        sender() ! PoisonPill
        self ! PoisonPill
      }
  }
}


val system2 = ActorSystem("pingpong2")
val player1 = system2.actorOf(Props(classOf[Player],null),"player1")
val player2 = system2.actorOf(Props(classOf[Player],player1), "player2")
player2 ! Ping*/


