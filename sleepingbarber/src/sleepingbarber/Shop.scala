package sleepingbarber
import scala.actors.Actor

class Shop extends Actor {

  val barber = new Barber();
  barber.start();

  def act {
    println("[s] Shop is open Now");
    loop {
      react {
        case customer: Customer => barber ! customer
      }
    }
  }

}
