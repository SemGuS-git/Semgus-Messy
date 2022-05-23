import org.junit.Test
import lex.Lexer
import parse.Parser
import parse.Translator
import semgusJava._
import java.io.File

import scala.io.Source

class SemgusJavaTestSuite {
  @Test
  def SemgusJavaTest: Unit = {
    val s = semgusJava.JSON2Semgus("./resources/sum-while.json")
    utils.printCyan(s.toString)
    val smt = genConstraints.genBasic.semgus2SMT(s)
    utils.printGreen(smt.mkString("\n"))
    utils.write2File("./resources/sum-while.z3")(smt.mkString("\n"))
  }
}