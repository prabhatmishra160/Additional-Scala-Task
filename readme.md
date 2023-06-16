
#Shopping Cart calculator Program
### About the program :
The shopping-cart program is a Scala program that simulates a shopping cart, allowing the user to add items and calculate the total price with any applicable discounts.

It includes several classes:

#### Product: Defines a product with a name and a price.

####ShoppingCart: Maintains a list of items added to the cart.

####Discount: Represents a discount that can be applied to a product.

####DiscountCalculator: Calculates the total discount for a given shopping cart.

####ShoppingcartApp: use Run() method to execute main logics of the program.

#### Main: this is entry point of the program which call run method to execute program

the program reads a string of input from the user, which represents the names of the products they want to add to their cart. It then calculates any applicable discounts and displays the final price.

#Prerequisites

Installation
To run this application, you will need to have Scala and SBT installed on your system. You can install them by following the instructions provided in the links below:

Scala: https://www.scala-lang.org/download/ 
version:"3.1.1"

SBT: https://www.scala-sbt.org/1.x/docs/Setup.html
version:1.8.2

Once you have installed Scala and SBT, 

### Run
To run the application,

navigate to the project directory main and run the following command

sbt run

####Testing
To run the test suite for the application, navigate to the project directory test
nd run the following command:

testOnly ShoppingCartTest


# input :
Enter a string: "soup bread bread milk apples"
# Output :
Discount for each item:

apples 10.00%  off: £0.10P

Subtotal: £4.20

Total price: £4.10

#output of test cases

* A shopping cart -should allow adding and removing items should calculate 

* total price correctly -should calculate total discount correctly

* An item discount - should apply discount to items correctly A 

* special offer - should apply discount to items correctly
 
* Total number of tests run: 5

* Suites: completed 1, aborted 0

* Tests: succeeded 5, failed 0, canceled 0, ignored 0, pending 0

* All tests passed.
###Known Issues :

The program assumes that the user will input valid product names seprated by space and that the product list contains all products the user may input. If the user inputs an incorrect product name or the product list is incomplete, the program will throw an exception.