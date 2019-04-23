package adt

import collection.mutable

class SLList[A] extends mutable.Buffer[A]{
  import SLList.Node
  private var top: Node[A] = null
  private var tl:Node[A] = null
  private var numElems = 0

  
  
  def +=(elem: A): this.type = {
   val n = new Node[A](elem, null)
   if(top == null) {
     top = n
   } else {
     tl.next = n
   }
   tl = n
   numElems += 1
   this
  }
  
  
  def +=:(elem: A): this.type = ???

  
  
  def apply(n: Int): A = {
    require(n >= 0)
    var rover = top
    for(i <- 0 until n) rover = rover.next
    rover.data
  }
  
  def clear(): Unit = {
    top = null
    tl = null
    numElems = 0
  }
  
  
  def insertAll(n: Int,elems: Traversable[A]): Unit = ???
  
  
  def length: Int = numElems
  
  
  def remove(n: Int): A = {
    numElems -=1
    if(n ==0) {
      val ret = top.data
      top = top.next
      if(top == null) tl = null
      ret
    }else{
    var rover = top
    for(i <- 0 until n-1) rover = rover.next
    if(rover.next == tl) tl = rover
    val ret = rover.next.data
    rover.next = rover.next.next
    ret
  }
}
  
  
  def update(n: Int,newelem: A): Unit = {
    require(n >=0)
    var rover = top
    for(i <- 0 until n) rover = rover.next
    rover.data = newelem
  }
  
  // Members declared in scala.collection.IterableLike
  def iterator = new Iterator[A] {
    var rover = top 
    def hasNext:Boolean = rover != null
    def next(): A = {
      val ret = rover.data
      rover = rover.next
      ret
    }
  }
}


object SLList {
  private class Node[A]( var data: A, var next: Node[A])
}