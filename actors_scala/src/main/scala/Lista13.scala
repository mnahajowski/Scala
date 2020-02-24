import akka.actor.{ Actor, ActorRef, ActorSystem, PoisonPill, Props }

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
player2 ! Ping


