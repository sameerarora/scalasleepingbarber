package sleepingbarber
import scala.actors.Actor

class Customer(val id: Int) extends Actor {
  var shorn = false
  
	def act()={
	  loop{
		  react{
		    case Haircut=>{
		      shorn=true
		      println("[c] customer "+id+" got a haircut")
		    }
		  }
	  }
	}
}