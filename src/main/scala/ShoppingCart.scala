/**

Represents a shopping cart.
A shopping cart allows users to add and remove items, get the list of items in the cart,
calculate the total price of all items in the cart, and calculate the total discount
based on a list of discounts applied to the items in the cart.
The items in the cart are represented by instances of the Item trait, and the discounts
are represented by instances of the Discount trait.
@constructor Create a new shopping cart with an empty list of items.
 */
class ShoppingCart {
  private var items: List[Item] = List()
  /** Add an item to the shopping cart. */
  def addItem(item: Item): Unit = {
    items = item :: items
  }

  /** Remove an item from the shopping cart. */
  def removeItem(item: Item): Unit = {
    items = items.filterNot(_ == item)
  }

  /** Get the list of items in the shopping cart. */
  def getItems: List[Item] = {
    items
  }

  /** Calculate the total price of all items in the shopping cart. */
  def getTotalPrice: Double = {
    items.map(_.price).sum
  }

  /** Calculate the total discount based on a list of discounts applied to the items in the cart. */
  def getTotalDiscount(discounts: List[Discount]): Double = {
    discounts.map(_.applyDiscount(items)).sum
  }
}