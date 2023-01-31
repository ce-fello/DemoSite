package my.site.server

import my.site.db.User
import spark.Request


object Helpers {
  def isUserLoggedIn(request: Request): Boolean = {
    val userName: Option[String] = Option(request.cookie("userName"))
    userName.nonEmpty && User.reqUser(userName.get).nonEmpty
  }
}