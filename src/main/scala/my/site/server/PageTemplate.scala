package my.site.server

import scala.io.Source


object PageTemplate {
  def genPage(content: String): String = {
    val fileName = "src/main/scala/my/site/server/Frontend/MainPage.html"
    val htmlContent = Source.fromFile(fileName).getLines().mkString
    val a = htmlContent.stripMargin
    a
  }
}