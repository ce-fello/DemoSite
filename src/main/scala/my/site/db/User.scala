package my.site.db

import scalikejdbc._


object User {
  def reqUser(name: String): Option[User] = {
    implicit val session: AutoSession.type = AutoSession
    sql"""SELECT * FROM Users WHERE name = $name"""
      .map(rs => User(rs.int("user_id"), rs.string("login"), rs.string("password"),
        rs.string("email"), rs.boolean("mailing"), rs.string("birthday"))).single.apply()
  }

  def getUserId(name: String): Option[Int] = {
    implicit val session: AutoSession.type = AutoSession
    sql"""SELECT * FROM Users WHERE name = $name""".map(rs => rs.int("user_id")).single.apply()
  }

  def allUsers(): Seq[User] = {
    implicit val session: AutoSession.type = AutoSession
    sql"""SELECT * FROM Users""".map(rs => User(rs.int("user_id"), rs.string("login"), rs.string("password"),
      rs.string("email"), rs.boolean("mailing"), rs.string("birthday"))).list.apply()
  }

}

case class User(user_id: Int, login: String, password: String, email: String, mailing: Boolean, birthday: String) {
}