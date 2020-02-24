import scala.collection.mutable.ArrayBuffer
import scala.util.Random
import scala.io.StdIn._
class Kalaha {
  def display(): Unit = {
    println(player1)
    println(player2)
  }

  def initialization(): Unit = {
    player1 += 0
    player2 += 0
    for(w <- 0 to 5) {
      player1 += 6
      player2 += 6
    }
    //println(player1.size)
  }

  def process(): Unit = {
    this.display()
    while(checkSum(player1) && checkSum(player2)) {
      var index = move(player1, 1, player2)

      while(index == 0) {
        this.display()
        println("Before another move of player 1\n")
        index = move(player1, 1,player2)
      }
      if(player1(index) == 1) {
        player1(0) += player2(index)
        player2(index) = 0
      }

      //println("\nAfter move of 1st player, chose index = " + index + "\n")
      this.display()

      index = move(player2, 2, player1)

      while(index == 0) {
        this.display()
        println("Before another move of player 2\n")
        index = move(player2, 2, player1)
      }

      if(player2(index) == 1) {
        player2(0) += player1(index)
        player1(index) = 0
      }
      //println("\nAfter move of 2nd player, chose index = " + index + "\n")
      this.display()

    }
    if(checkSum(player1)) {
      allToBase(player1)
    } else if(checkSum(player2)) {
      allToBase(player2)
    }
  }

  def allToBase(arr : ArrayBuffer[Int]) = {
    for(i <- 1 to 6) {
      if(arr(i) != 0) {
        arr(0) += arr(i)
        arr(i) = 0
      }
    }
  }

  def checkSum(arr : ArrayBuffer[Int]) : Boolean = {
    var sum = 0
    var i=1
    while(i < arr.length) {
      sum += arr(i)
      i += 1
    }
    if(sum != 0)
      return true
    else
      return false
  }

  def move(arr : ArrayBuffer[Int], player : Int, arr2: ArrayBuffer[Int]) : Int = {
    val gen = new Random()
    var rand_index = gen.nextInt(arr.size)

    while(rand_index == 0) {
      rand_index = gen.nextInt(arr.size)
    }
    //var number_of_pawns = arr(rand_index)
    //arr(rand_index) = 0
    //val new_index = algorithm(arr, arr2)
    var current_index = algorithm(arr, arr2)
    var number_of_pawns = arr(current_index)
    arr(current_index) = 0
    //println("\nindeks " + current_index + "\n")
    println("\nBefore move of player " + player + ", chose index = " + current_index + "\n")
    //var current_index = rand_index


    while(number_of_pawns > 0) {
      current_index -=1
      if(current_index < 0) {
        current_index = arr.size - 1
      }
      arr(current_index) += 1
      number_of_pawns -= 1
    }

    current_index
  }

  def copy(arr : ArrayBuffer[Int]) : ArrayBuffer[Int] = {
    var player_temp = ArrayBuffer.empty[Int]
    for(w <-0 to 6) {
      player_temp += arr(w)
    }
    player_temp
  }

  def algorithm(arr : ArrayBuffer[Int], arr2 : ArrayBuffer[Int]) : Int = {
    var best_choice = 1
    var player_temp = copy(arr)
    var test = 1
    var player2_temp = copy(arr2)
    var curr = change_values(player_temp, player2_temp, 1)
    var best_score = score(player_temp, player2_temp)
    var best_score1 = score(player_temp, player2_temp)
    for(w <- 2 to 6) {
      player_temp = copy(arr)
      player2_temp = copy(arr2)
      var current = change_values(player_temp, player2_temp, w)
      var temp_score = score(player_temp, player2_temp)
      if(temp_score > best_score) {
        best_score = temp_score
        best_choice = w
      }
      if(temp_score != best_score)
        test = 0
    }

    if(test == 1) {
      best_choice = maxim(arr)
    }

    best_choice
  }

  def maxim(arr1: ArrayBuffer[Int]) : Int = {
    var maxim_value = arr1(1)
    var maxim_index = 1
    for(w <- 2 to 6) {
      if(arr1(w) > maxim_value) {
        maxim_value = arr1(w)
        maxim_index = w
      }
    }
    maxim_index
  }

  def change_values(arr : ArrayBuffer[Int], arr2 : ArrayBuffer[Int], index : Int) : Int = {
    var current_index = index
    var number_of_pawns = arr(index)
    arr(index) = 0
    while(number_of_pawns > 0) {
      current_index -=1
      if(current_index < 0) {
        current_index = arr.size - 1
      }
      arr(current_index) += 1
      number_of_pawns -= 1
    }

    if(arr(current_index) == 1) {
      arr(0) += arr2(current_index)
      arr2(current_index) = 0
    }
    current_index
  }

  def score(arr : ArrayBuffer[Int], arr2 : ArrayBuffer[Int]) : Int = {
    arr(0) - arr2(0)
  }


  def winner(): Unit = {
    if(player1(0) > player2(0))
      println("\nPlayer 1 won!\n")
    else if(player1(0) < player2(0))
      println("\nPlayer 2 won!\n")
    else
      println("\nIt's a draw!\n")

    println("\nScore is " + player1(0) + " : " + player2(0))
  }

  def withPlayer() = {
    this.display()
    while(checkSum(player1) && checkSum(player2)) {
      println("\nPodaj indeks\n")
      var indeks = readInt()
      var curr = change_values(player1,player2,indeks)
      while(curr == 0) {
        this.display()
        println("\nPodaj kolejny indeks\n")
        indeks = readInt()
        curr = change_values(player1, player2, indeks)
      }

      this.display()

      indeks = move(player2, 2, player1)

      while(indeks == 0) {
        indeks = move(player2, 2, player1)
      }

      if(player2(indeks) == 1) {
        player2(0) += player1(indeks)
        player1(indeks) = 0
      }
      //println("\nAfter move of 2nd player, chose index = " + index + "\n")
      this.display()
    }

  }


  var player1 = ArrayBuffer.empty[Int]
  var player2 = ArrayBuffer.empty[Int]

}

object Start extends App {
  val gen = new Random()
  val game = new Kalaha
  game.initialization()
  println("Choose game\n1.Computer vs Computer\n2.Player vs Computer\n")
  val chosen = readInt()
  if(chosen == 1) {
    game.process()
  } else if(chosen == 2) {
    game.withPlayer()
  } else {
    println("Wrong choice!\n")
  }
  println("\nEnd of the game\n")
  game.winner()
}
