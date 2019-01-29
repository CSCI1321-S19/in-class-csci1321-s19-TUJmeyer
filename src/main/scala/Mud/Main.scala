package Mud

import io.StdIn._
object Main {
  def main(args:Array[String]): Unit ={
    println("Hello citizen. What would you like to be called?")
    val name = readLine()
    println("Hello",name,  ", Enjoy your stay in Tokyo 2099")
    val RoomNow = Room.readRooms()    
  }
  def ReadInput(userInput:String): Unit ={
    var userInput = readLine()
    while (userInput != "exit") {
      ReadInput(_)
    }
    if (userInput == "exit") {
      System.exit(0)
    }
  }
  ReadInput(readLine())
}