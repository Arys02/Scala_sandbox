package esgi;

case class IntSet(l: Int*) extends Iterable[Int] {
  val elem: Iterable[Int] = {
    var xs = List[Int]()
    l.foreach(x => if (!xs.contains(x)) xs = x :: xs)
    xs
  }

  override def iterator: Iterator[Int] = elem.iterator

  override def toString: String = {
    f"IntSet(${elem.mkString(",")})"
  }

  def append(x: Int): IntSet = IntSet(x +: elem.toSeq: _*)

  def +(other: IntSet): IntSet = IntSet(elem.toSeq ++ other.elem: _*)

  def &(other: IntSet): IntSet = IntSet(
    (for (x <- elem.toSeq; y <- other.elem.toSeq if x == y) yield x): _*
  )
}

object IntSetApp extends App {
  val mySet = IntSet(1, 1, 2, 2, 3, 3, 3, 4, 4)
  println(mySet.append(8))
  println {
    IntSet(1, 2, 2, 3, 4, 4) + IntSet(2, 3, 3, 5, 5, 6)
  }
  println {
    IntSet(1, 2, 2, 3, 4, 4) & IntSet(2, 3, 3, 5, 5, 6)
  }
}
