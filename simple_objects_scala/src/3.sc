class Pojazd(private val producent: String, private val model: String, private val rok: Int = -1, private var rejestracja:
String = "") {
  //println("jestem")
  def model2: String = model
  def rokk : Int = rok

  def this(producent: String, model: String, rejestracja: String) {

    this(producent, model, -1, rejestracja)
    println("jestem")
  }

}

object Test extends App {
  val t = new Pojazd("Fiat","126p" ,2016,"ESI123")
  new Pojazd("Fiat", "126p", 2016)
  new Pojazd("Fiat", "126p", "ESI123")
  new Pojazd("Fiat" , "126p")
}
println("1")
val t = new Pojazd("Fiat","126p" ,2016,"ESI123")

t.model2
t.rokk
println("2")
val b = new Pojazd("Fiat", "126p", 2016)
b.rokk
println("3")
val c = new Pojazd("Fiat", "126p", "ESI123")
println("4")
val d = new Pojazd("Fiat" , "126p")
d.rokk





