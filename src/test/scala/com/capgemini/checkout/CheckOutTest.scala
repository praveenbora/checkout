package com.capgemini.checkout

import org.scalatest._
import com.capgemini.checkout.Cart._

class CheckOutTest extends FeatureSpec with GivenWhenThen {

  feature("Shopping cart checkout") {

    scenario("Empty cart") {
      Given("an empty shopping cart")
      val emptyCart = Cart(Nil)
      assert(emptyCart.items.isEmpty)

      When("calculating the cost")
      val totalcost = Cart.totalCost(emptyCart)

      Then("the total cost is zero")
      assert(totalcost == 0.0)
    }

    scenario("Cart with one apple") {
      Given("a shopping cart with one apple")
      val cartWithOneApple = Cart(List(APPLE))
      assert(cartWithOneApple.items.size == 1)

      When("calculating the cost")
      val totalcost = Cart.totalCost(cartWithOneApple)

      Then("the total cost is £0.60")
      assert(totalcost == 0.60)
    }

    scenario("Cart with one orange") {
      Given("a shopping cart with one orange")
      val cartWithOneOrange = Cart(List(ORANGE))
      assert(cartWithOneOrange.items.size == 1)

      When("calculating the cost")
      val totalcost = Cart.totalCost(cartWithOneOrange)

      Then("the total cost is £0.25")
      assert(totalcost == 0.25)
    }

    scenario("Cart with multiple apples and no oranges") {
      Given("a shopping cart with three apples")
      val cartWithThreeApples = Cart(List(APPLE, APPLE, APPLE))
      assert(cartWithThreeApples.items.size == 3)

      When("calculating the cost")
      val totalcost = Cart.totalCost(cartWithThreeApples)

      Then("the total cost is £1.80")
      assert(totalcost == 1.80)

    }

    scenario("Cart with multiple oranges and no apples") {
      Given("a shopping cart with three oranges")
      val cartWithThreeOranges = Cart(List(ORANGE, ORANGE, ORANGE))
      assert(cartWithThreeOranges.items.size == 3)

      When("calculating the cost")
      val totalcost = Cart.totalCost(cartWithThreeOranges)

      Then("the total cost is £0.75")
      assert(totalcost == 0.75)

    }

    scenario("Cart with multiple items of different types") {
      Given("a shopping cart with three apples")
      val cart = Cart(List(APPLE, APPLE, ORANGE, APPLE))
      assert(cart.items.size == 4)

      When("calculating the cost")
      val totalcost = Cart.totalCost(cart)

      Then("the total cost is £2.05")
      assert(totalcost == 2.05)
    }

    // Step 2

    scenario("Cart with two apples and offer applied") {
      Given("a shopping cart with two apples")
      val cart = Cart(List(APPLE, APPLE))
      assert(cart.items.size == 2)

      When("calculating the cost with the offer on apples applied")
      val totalcost = Cart.totalCostWithOffers.apply(cart)

      Then("the total cost is £0.60")
      assert(totalcost == 0.60)
    }

    scenario("Cart with three oranges and offer applied") {
      Given("a shopping cart with three oranges")
      val cart = Cart(List(ORANGE, ORANGE, ORANGE))
      assert(cart.items.size == 3)

      When("calculating the cost with the offer on oranges applied")
      val totalcost = Cart.totalCostWithOffers.apply(cart)

      Then("the total cost is £0.50")
      assert(totalcost == 0.50)
    }

    scenario("Cart where offer is applied to apples but not on oranges") {
      Given("a shopping cart with four apples and one orange")
      val cart = Cart(List(APPLE, APPLE, ORANGE, APPLE, APPLE))
      assert(cart.items.size == 5)

      When("calculating the cost with the offer on apples applied but not on oranges")
      val totalcost = Cart.totalCostWithOffers.apply(cart)

      Then("the total cost is £1.45")
      assert(totalcost == 1.45)
    }

    scenario("Cart where offer is applied to oranges but not on apples") {
      Given("a shopping cart with four oranges and one apple")
      val cart = Cart(List(ORANGE, ORANGE, ORANGE, APPLE, ORANGE))
      assert(cart.items.size == 5)

      When("calculating the cost with the offer on oranges applied but not on apples")
      val totalcost = Cart.totalCostWithOffers.apply(cart)

      Then("the total cost is £1.35")
      assert(totalcost == 1.35)
    }

  }

}