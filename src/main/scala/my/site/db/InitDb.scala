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
          );
          alter table Users add constraint users_user_id_primary primary(user_id);
          alter table Users add constraint users_login_unique unique(login);
       """.execute.apply()

    sql"""
          create table if not exists Payments(
          payment_id serial not null primary key,
          customer_id int not null,
          bundle int not null,
          amount int not null,
          date date not null
          );
          alter table Payments add primary key payments_payment_id_primary(payment_id);
       """.execute.apply()

    sql"""
          create table if not exists Bundles(
          bundle_id serial not null primary key,
          bundle_name varchar(64) not null,
          products_inside_id int not null
          );
          alter tables Bundles add primary key bundles_bundle_id_primary(bundle_id)
       """.execute.apply()

    sql"""
          create table if not exists Products_types(
          products_types_id serial not null primary key,
          price double not null,
          duration bigint not null
          );
          alter table Products_types add primary key products_types_product_type_id_primary(product_type_id);
       """.execute.apply()

    sql"""
          alter table Payments add constraint payment_customer_id_foreign foreign key(customer_id) references Users(user_id);
          alter table Bundles add constraint bundles_products_inside_id_foreign foreign key(products_inside_id) references Products_types(product_type_id)
          alter table Payments add constraint payment_bundle_foreign foreign key(bundle) references Bundles(bundle_id);
       """.execute.apply()
  }
}
