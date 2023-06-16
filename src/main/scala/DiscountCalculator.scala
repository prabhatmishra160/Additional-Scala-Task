/**
 * A class for calculating the total discount on a given shopping cart using a list of discount rules.
 *
 * @param discounts a list of discount rules to be applied to the items in the shopping cart
 */
class DiscountCalculator(discounts: List[Discount]) {
  def calculateDiscount(shoppingCart: ShoppingCart): Double = {
    shoppingCart.getTotalDiscount(discounts)
  }
}