@main
def main(): Unit = {
  println("Hello world!")

  val myTuple = Tuple2(false, 2)
  myTuple match {
    case (false, 3) => println("Constant Pattern")
    case (_, 3) => println("Regex Pattern")
    case _ => println("Wildcards Pattern")
  }
}