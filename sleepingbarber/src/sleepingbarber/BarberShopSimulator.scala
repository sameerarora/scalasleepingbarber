package sleepingbarber
import scala.util.Random
import scala.collection.{ immutable, mutable }

object BarberShopSimulator {

  private val random = new Random();
  private val customers = new mutable.ArrayBuffer[Customer]()
  private val shop = new Shop()

  def generateCustomers(): Unit = {
    for (i <- 1 to 20) {
      val customer = new Customer(i)
      customer.start()
      customers += customer
    }
    println("Generated " + customers.size + " customers")
  }

  def sendCustomers {
    for (customer <- customers) {
      shop ! customer
      Thread.sleep(random.nextInt(450));
    }
  }

  def tallyCuts {
    Thread.sleep(2000)
    val shornCount = customers.filter(c => c.shorn).size
    println("[!] " + shornCount + " customers got haircut today")
  }

  def main(args: Array[String]) {
    shop.start()
    generateCustomers
    sendCustomers
    tallyCuts

    System.exit(0);
  }

}