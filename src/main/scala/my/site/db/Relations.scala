package my.site.db

import scalikejdbc._

object Relations {
  def createOrder(userId: Int, bundleId: Int): Unit = {
    implicit val session = AutoSession
    sql"""insert into Relations(userId, bundleId) VALUES($userId, $bundleId)""".update.apply()
  }

  def getAllOrders(): Seq[(User, Bundle)] = {
    implicit val session = AutoSession
    sql"""
         SELECT * FROM Users INNER JOIN Relations ON Users.id = Relations.userId
         INNER JOIN Bundles ON Bundles.bundle_id = Relations.bundleId
         """.map(rs => (User(rs.int("user_id"), rs.string("login"), rs.string("password"),
      rs.string("email"), rs.boolean("mailing"), rs.string("birthday")),
      Bundle(rs.int("bundle_id"), rs.string("bundle_name"),
        rs.int("products_inside_id")))).list.apply()
  }
}
