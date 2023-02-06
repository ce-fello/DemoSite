package my.site.db

import scalikejdbc._


object User {
//  def isMemberOfMailing(login: String): Option[User] = {
//    implicit val session = AutoSession
//    sql"""SELECT * FROM Users WHERE login = $login AND mailing = true""".map(x => x).single.apply()
//  }

  def reqUser(name: String): Option[User] = {
    implicit val session = AutoSession
    sql"""select * from Users WHERE name = $name"""
      .map(rs => User(rs.int("user_id"), rs.string("login"), rs.string("password"),
        rs.string("email"), rs.boolean("mailing"), rs.string("birthday"))).single.apply()
  }
}

case class User(user_id: Int, login: String, password: String, email: String, mailing: Boolean, birthday: String){

}