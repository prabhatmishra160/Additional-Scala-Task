
    /**
     * A trait representing an item, with a name and a price.
     */
    trait Item {
      /**
       * The name of the item.
       */
      def name: String

      /**
       * The price of the item.
       */
      def price: Double
    }

    /**
     * A case class representing a product, which is an item with a name and a price.
     * It overrides the `equals` method to compare products based on their name and price.
     *
     */
    case class Product(name: String, price: Double) extends Item {
      override def equals(that: Any): Boolean = {
        that match {
          case other: Product => name == other.name && price == other.price
          case _ => false
        }
      }
    }

  


