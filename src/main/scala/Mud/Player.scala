package Mud

class Player(
  val name: String,
  private var inventory: List[String],
  private var RoomNow: Array[Room]){
 
    
   
 
 
 
  
   def processCommand(command: String): Unit = {
    command match {
      case "North" => move("0")
      case "South" => move("1")
      case "East" => move("2")
      case "west" => move("3")
      case "look" => println (Room.readRooms())
      case "inv" => inventoryListing
      //Item Help
      case "get" => addToInventory(Item)
      case "drop" => inventory -=(Item)
      //
      case "exit" => System.exit(0)
      case "help" =>
      case _ => println("Invalid Command")
    }

  
  def getFromInventory(itemName: String): Option[Item] = ???
  
  //Mud Item require Int
  def addToInventory(item: Item): Unit = {
    inventory :: Room.rooms(item)
  }
  
  //not sure why this needs to be a unit (want string)
  def inventoryListing(): Unit = {
    println("You currently have on you...") 
    for(i <- inventory) {
      println (i)
    }
  }
  
  
  def move(dir: String): Unit = {
    if ((Room.rooms).contains(dir)) {
      RoomNow =(Room.rooms)
      print(RoomNow)
    }
  }

 object Player {
    
        
    }
  }
}
