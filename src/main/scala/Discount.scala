/**
 * Represents a discount on a specific item.
 *
 * @param item the item that the discount applies to
 * @param discount the amount of discount to apply
 */
case class ItemDiscount(item: Item, discount: Double) extends Discount {
  /**
   * Applies the discount to a list of items, returning the total amount discounted.
   *
   * @param items the list of items to apply the discount to
   * @return the total amount discounted
   */
  override def applyDiscount(items: List[Item]): Double = {
    items.count(_ == item) * discount
  }
  /**
   * Determines whether this discount is equal to another discount.
   *
   * @param that the other discount to compare to
   * @return true if the discounts are equal, false otherwise
   */
  override def equals(that: Any): Boolean = {
    that match {
      case other: ItemDiscount => item == other.item && discount == other.discount
      case _ => false
    }
  }
}
/**
 * Represents a special offer where a certain quantity of one item can be purchased at a discount
 * when a certain quantity of another item is also purchased.
 *
 * @param item the item that the offer applies to
 * @param quantity the quantity of the item that must be purchased to qualify for the offer
 * @param discountedItem the item that can be purchased at a discount when the qualifying item is purchased
 * @param discount the amount of discount to apply
 */
case class SpecialOffer(item: Item, quantity: Int, discountedItem: Item, discount: Double) extends Discount {
  /**
   * Applies the discount to a list of items, returning the total amount discounted.
   *
   * @param items the list of items to apply the discount to
   * @return the total amount discounted
   */
  override def applyDiscount(items: List[Item]): Double = {
    val count = items.count(_ == item)
    val discountedCount = items.count(_ == discountedItem)
    // (count / quantity) * discount * Math.min(discountedCount, count)
    (count / quantity) * discount * (discountedCount min count)

  }
  /**
   * Determines whether this discount is equal to another discount.
   *
   * @param that the other discount to compare to
   * @return true if the discounts are equal, false otherwise
   */

  override def equals(obj: Any): Boolean = obj match {
    case other: SpecialOffer =>
      item == other.item &&
        quantity == other.quantity &&
        discountedItem == other.discountedItem &&
        discount == other.discount
    case _ => false
  }
}
/**
 * Represents a discount that can be applied to a list of items.
 */
trait Discount {
  /**
   * Applies the discount to a list of items, returning the total amount discounted.
   *
   * @param items the list of items to apply the discount to
   * @return the total amount discounted
   */
  def applyDiscount(items: List[Item]): Double
}
