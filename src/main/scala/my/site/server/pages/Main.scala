package my.site.server.pages

import my.site.server.{PageTemplate, Helpers}
import spark.{Spark, Request, Response}


object Main {
  def makeEndpoints(): Unit = {
    Spark.get("/", (request: Request, response: Response) =>
      PageTemplate.genPage("<h1>MAIN PAGE</h1>"))
  }
}