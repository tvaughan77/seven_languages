package com.opower

import com.opower.sizer._
import scala.actors._
import Actor._

object Driver {
  val urls = List("http://www.opower.com",
                  "http://www.amazon.com",
                  "http://www.google.com",
                  "http://www.sapient.com",
                  "http://www.reddit.com")

  
  def main(args: Array[String]) {
    println("Sequential run: ")
    timeMethod { getPageSizeSequentially }

    println("Concurrent run: ")
    timeMethod { getPageSizeConcurrently }
  }
  
  /*
   * Times a method's execution and prints out how long the method took to run.  Not very functional
   */
  def timeMethod(method: () => Unit) = {
    val start = System.nanoTime
    method()
    val stop = System.nanoTime

    println("Method took " + (stop - start)/1000000000.0 + " seconds.")
  }
  
  /*
   * Gets each of the {@code urls} sequentially and calculates their individual sizes 
   */
  def getPageSizeSequentially() = {
    for(url <- urls) {
      println("Size for " + url + ": " + PageLoader.getPageSize(url))
    }
  }

  /*
   * Gets each of the {@code urls} concurrently (using the actor model) and calculates their individual sizes
   */
  def getPageSizeConcurrently() = {
    val caller = self

    for(url <- urls) {
      actor { caller ! (url, PageLoader.getPageSize(url))}
    }

    for(url <- urls) {
      receive {
        case(url, size) => println("Size for " + url + ": " + size)
      }
    }
  }
}
