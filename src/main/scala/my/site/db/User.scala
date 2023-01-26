package my.site.db

import scalikejdbc._

object User {
  def isMemberOfMailing(login: String): Unit = {
    implicit val session = AutoSession
    sql"""SELECT * FROM Users WHERE login = $login AND mailing = true""".map(x => x).single.apply()
  }
}

case class User(user_id: Int, login: String, password: String, email: String, mailing: Boolean, birthday: String){

}