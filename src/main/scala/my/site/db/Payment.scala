package my.site.db

object Payment {

}

case class Payment(payment_id: Int, customer_id: Int, bundle: Int, amount: Int, date: String) {

}
