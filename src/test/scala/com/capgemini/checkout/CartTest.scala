package com.capgemini.checkout

import com.capgemini.checkout.Cart._
import org.scalatest.FunSuite

class CartTest extends FunSuite {

  test("Applying the buy one apple get one free offer to an empty cart should return an empty cart") {
    val emptyCart = Cart(Nil)
    val newCart = Cart.buyOneAppleGetOneFree(emptyCart)
    assert(emptyCart.items.size === newCart.items.size)
  }

  test("Applying the buy three oranges for two offer to an empty cart should return an empty cart") {
    val emptyCart = Cart(Nil)
    val newCart = Cart.buyThreeOrangesForThePriceOfTwo(emptyCart)
    assert(emptyCart.items.size === newCart.items.size)
  }

  test("Applying the buy one apple get one free offer to a cart with two apples should return a cart with one apple") {
    val appleCart = Cart(List(APPLE, APPLE))
    val newAppleCart = Cart.buyOneAppleGetOneFree(appleCart)
    assert(newAppleCart === Cart(List(APPLE)))
  }

  test("Applying the buy three oranges for two offer to a cart with three oranges should return a cart with two oranges") {
    val orangeCart = Cart(List(ORANGE, ORANGE, ORANGE))
    val newOrangeCart = Cart.buyThreeOrangesForThePriceOfTwo(orangeCart)
    assert(newOrangeCart === Cart(List(ORANGE, ORANGE)))
  }

  // tests odd number logic
  test("Applying the buy one apple get one free offer to a cart with three apples should return a cart with two apples") {
    val appleCart = Cart(List(APPLE, APPLE, APPLE))
    val newAppleCart = Cart.buyOneAppleGetOneFree(appleCart)
    assert(newAppleCart === Cart(List(APPLE, APPLE)))
  }

  // tests even number logic
  test("Applying the buy three oranges for two offer to a cart with four oranges should return a cart with three oranges") {
    val orangeCart = Cart(List(ORANGE, ORANGE, ORANGE, ORANGE))
    val newOrangeCart = Cart.buyThreeOrangesForThePriceOfTwo(orangeCart)
    assert(newOrangeCart === Cart(List(ORANGE, ORANGE, ORANGE)))
  }

  test("Applying the buy one apple get one free offer to a cart with no oranges and one apple should return a cart with one apple") {
    val appleCart = Cart(List(APPLE))
    val newAppleCart = Cart.buyOneAppleGetOneFree(appleCart)
    assert(newAppleCart === Cart(List(APPLE)))
  }

  test("Applying the buy three oranges for two offer to a cart with no apples and one orange should return a cart with one orange") {
    val orangeCart = Cart(List(ORANGE))
    val newOrangeCart = Cart.buyThreeOrangesForThePriceOfTwo(orangeCart)
    assert(newOrangeCart === Cart(List(ORANGE)))
  }

}