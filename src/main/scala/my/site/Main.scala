package my.site

import my.site.db.InitDb
import my.site.server.{InitEndpoints, PageTemplate}
import scala.util.Random

object Main {
  def main(args: Array[String]): Unit = {
    InitDb.init()
    InitEndpoints.init()
  }
}
