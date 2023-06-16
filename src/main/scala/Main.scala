/**

The Main object serves as the entry point for the application. It creates an instance of ShoppingcartApp
and invokes its run method to run the shopping cart program.
The ShoppingcartApp class contains the logic for running the program, which reads user input, adds items to the cart,
applies discounts, and prints the subtotal, discounts, and total price. The program assumes that the user inputs valid
product names, and that the product stock map contains all products that the user may input. If an invalid product name is
entered, the program will print an error message and prompt the user to enter a valid product name.
 */
object Main {
  def main(args: Array[String]): Unit = {
    val app = new ShoppingcartApp()
    app.run()
  }
}