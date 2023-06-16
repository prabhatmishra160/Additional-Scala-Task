import scala.io.StdIn
import scala.util.{Failure, Success, Try}
/**

The ShoppingcartApp class represents a simple shopping cart application that allows users to input a string of
item names separated by spaces and calculates the total price, discounts, and final price based on the items in
the cart and any available discounts.
@constructor creates a new ShoppingcartApp instance with a pre-defined stock of products.
 */
class ShoppingcartApp {


  def run():Unit = {
    val soup = Product("soup", 0.65)
    val bread = Product("bread", 0.80)
    val milk = Product("milk", 1.3)
    val apples = Product("apples", 1.0)
    // Create a map of products and their names for easy access
    val productStock = Map(
      "soup" -> soup,
      "bread" -> bread,
      "milk" -> milk,
      "apples" -> apples
    )

    // Create a new shopping cart
    val cart = new ShoppingCart()

    // Prompt the user to enter a string of item names separated by spaces
    val inputString = StdIn.readLine("Enter the items in cart seprated by space: ")

    // Split the input string into individual item names
    val combinedLst = inputString.split(" ")

    // Add each item to the cart if it exists in the product stock map, otherwise throw an exception

    for (itm <- combinedLst) {
      Try(productStock(itm.toLowerCase())) match {
        case Success(product) => cart.addItem(product)
        case Failure(_) =>
          println(s"Invalid item name: $itm")
          println("Please enter a valid item name.")
          return // Exit the function and let the user try again
      }
    }

    // Define available discounts
    val discounts = List(
      ItemDiscount(apples, 0.1),
      SpecialOffer(soup, 2, bread, 0.5)
    )
    // Calculate the total discount for the cart based on the available discounts

    val discountCalculator = new DiscountCalculator(discounts)
    val discount = discountCalculator.calculateDiscount(cart)
    // Display the discount for each item in the cart
    println("Discount for each item:")
    val items = cart.getItems
    val itemDiscounts = items.map { item =>
      val itemCart = new ShoppingCart()
      itemCart.addItem(item)
      val itemDiscount = discountCalculator.calculateDiscount(itemCart)
      (item, itemDiscount)
    }
    // Calculate the subtotal, total price after discounts, and display the results to the user

    val subtotal = cart.getTotalPrice
    val totalPriceAfterDiscount = subtotal - discount

    println(f"Subtotal: £$subtotal%.2f")


    if (itemDiscounts.exists(_._2 > 0)) {
      for ((item, itemDiscount) <- itemDiscounts if itemDiscount > 0) {
        println(f"${item.name} ${itemDiscount * -100}%.2f%%  off: £${item.price * itemDiscount}%.2fP")
      }
    } else {
      println("(No offers available)")
    }
    println(f"Total price: £$totalPriceAfterDiscount%.2f")
  }}