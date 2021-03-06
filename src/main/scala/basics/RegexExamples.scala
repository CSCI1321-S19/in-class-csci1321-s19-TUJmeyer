package basics

object RegexExamples extends App {
  val numberedLine = """(\d+)\.(.*)""".r
  def numberedLines(lines: List[String]): Map[Int, String] = {
    (for(numberedLine(num, rest) <- lines) yield num.toInt -> rest).toMap
  }
  println(numberedLines(List("1. first","garbage","2.second")))
}