package my.site.db

import scalikejdbc._

object InitDb {
  def init(): Unit = {
    Class.forName("org.h2.Driver")
    ConnectionPool.singleton("jdbc:h2:file:~/test", "user", "pass")
    initTables()
  }

  private def initTables(): Unit = {
    implicit val session: AutoSession.type = AutoSession
    sql"""
          create table if not exists Users(
           user_id serial not null primary key,
           login varchar(64) not null,
           password varchar(64) not null,
           email varchar(64),
           mailing boolean,
           birthday date
           )
       """.execute.apply()

    sql"""
          create table if not exists Payments(
          payment_id serial not null primary key,
          customer_id int not null,
          bundle int not null,
          amount int not null,
          date date not null
          )
       """.execute.apply()

    sql"""
          create table if not exists Bundles(
          bundle_id serial not null primary key,
          bundle_name varchar(64) not null,
          products_inside_id int not null
          )
       """.execute.apply()

    sql"""
          create table if not exists Products_types(
          products_types_id serial not null primary key,
          price double not null,
          duration bigint not null
          )
       """.execute.apply()
  }
}
