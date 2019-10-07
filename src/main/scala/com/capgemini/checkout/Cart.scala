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

  /**
    * Calculates the total cost of the shopping cart with all offers applied
    *
    * @return total cost of the shopping cart
    */
  def totalCostWithOffers: (Cart) => BigDecimal = totalCost _ compose buyOneAppleGetOneFree _ compose buyThreeOrangesForThePriceOfTwo _

  /**
    * Returns a new cart with the buy one apple get one free price offer applied
    *
    * @param cart
    * @return a new cart with the offer applied
    */
  def buyOneAppleGetOneFree(cart: Cart): Cart = {
    val numberOfApples = cart.items.count(_ == APPLE)
    val offer = (numberOfApples / 2) + (numberOfApples % 2)
    val updatedItems = cart.items.filterNot(item => item == APPLE) ++ List.fill(offer)(APPLE)
    Cart(updatedItems)
  }

  /**
    * Returns a new cart with the buy three oranges for the price of two offer applied
    *
    * @param cart
    * @return a new cart with the offer applied
    */
  def buyThreeOrangesForThePriceOfTwo(cart: Cart): Cart = {
    val numberOfOranges = cart.items.count(_ == ORANGE)
    val offer = ((numberOfOranges / 3) * 2) + (numberOfOranges % 3)
    val updatedItems = cart.items.filterNot(item => item == ORANGE) ++ List.fill(offer)(ORANGE)
    Cart(updatedItems)
  }

}