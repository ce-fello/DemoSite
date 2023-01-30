package my.site.server

import my.site.server.pages._
import spark.{Request, Response, Spark}


object InitEndpoints {
  def init(): Unit = {
    Spark.externalStaticFileLocation("serverData")
    Spark.ipAddress("0.0.0.0")
    Spark.port(8080)
    Main.makeEndpoints()
  }
}
