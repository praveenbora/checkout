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



  }

}