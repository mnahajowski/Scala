/*def whileLoop(cond: => Boolean)(block: => Unit): Unit =
  if (cond) {
    block
    whileLoop(cond)(block)
  }
*/

def whileLoop(cond: => Boolean)(body: => Unit): Unit =
  if (cond) {
    body
    whileLoop(cond)(body)
  }
var i = 6
whileLoop (i > 0) {
  println(i)
  i -= 1
}