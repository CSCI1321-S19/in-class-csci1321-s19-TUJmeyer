package adt

import org.junit.Test
import org.junit.Assert._

class TestArrayQueue {
  @Test def emptyOnCreate (): Unit = {
    val testQueue = new ArrayQueue[Int]
    assertTrue(testQueue.isEmpty)
  }
  @Test def addOneToQueue() = {
    val queue = new ArrayQueue[Int]
    queue.enqueue(7)
    assertFalse(queue.isEmpty)
    assertEquals(7, queue.peek)
    assertEquals(7, queue.dequeue())
    assertTrue(queue.isEmpty)
  }
  @Test def addRemoveAdd() = {
    val queue = new ArrayQueue[Int]
    val nums1 = Array(1,2,3)
    for(n <- nums1) queue.enqueue(n)
    for(n <- nums1) assertEquals(n, queue.dequeue())
    assertTrue(queue.isEmpty)
    for(n <- nums1) queue.enqueue(n)
    for(n <- nums1) assertEquals(n, queue.dequeue())
  }
}