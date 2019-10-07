package com.capgemini.checkout

case class Cart(items: List[String])

object Cart {

  val APPLE = "Apple"
  val ORANGE = "Orange"

  private val priceOf: Map[String, Int] = Map((APPLE, 60), (ORANGE, 25))

  /**
    * Calculates the total cost of all the items in a cart.
    *
    * @param cart
    * @return total cost in pounds
    */
  def totalCost(cart: Cart): BigDecimal = cart.items.foldLeft(0)((total, item) => total + priceOf(item)) / 100.0



}