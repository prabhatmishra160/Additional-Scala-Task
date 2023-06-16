
import org.scalatest._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ShoppingCartTest extends AnyFlatSpec with Matchers {

  val soup = Product("soup", 0.65)
  val bread = Product("bread", 0.80)
  val milk = Product("milk", 1.3)
  val apples = Product("apples", 1.0)

  val itemDiscount = ItemDiscount(apples, 0.1)
  val specialOffer = SpecialOffer(soup, 2, bread, 0.5)

  "A shopping cart" should "allow adding and removing items" in {
    val cart = new ShoppingCart()
    cart.addItem(soup)
    cart.addItem(bread)
    cart.removeItem(soup)
    cart.getItems should be (List(bread))
  }
  it should "calculate total price correctly" in {
    val cart = new ShoppingCart()
    cart.addItem(soup)
    cart.addItem(bread)
    cart.addItem(milk)
    cart.getTotalPrice should be (soup.price + bread.price + milk.price)
  }
  it should "calculate total discount correctly" in {
    val cart = new ShoppingCart()
    cart.addItem(soup)
    cart.addItem(soup)
    cart.addItem(bread)
    cart.addItem(apples)
    val discounts = List(itemDiscount, specialOffer)
    cart.getTotalDiscount(discounts) should be (itemDiscount.applyDiscount(cart.getItems) + specialOffer.applyDiscount(cart.getItems))
  }

  "An item discount" should "apply discount to items correctly" in {
    val cart = new ShoppingCart()
    cart.addItem(apples)
    cart.addItem(apples)
    val discount = itemDiscount.applyDiscount(cart.getItems)
    discount should be (2 * apples.price * itemDiscount.discount)
  }

  "A special offer" should "apply discount to items correctly" in {
    val cart = new ShoppingCart()
    cart.addItem(soup)
    cart.addItem(soup)
    cart.addItem(bread)
    val discounts = List(itemDiscount, specialOffer)

    val discount = specialOffer.applyDiscount(cart.getItems) * bread.price
    discount should be (0.5 * bread.price)


  }


}
