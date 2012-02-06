package com.opower.sizer

import scala.io._
import scala.actors._
import Actor._

object PageLoader {
  def getPageSize(url: String) = Source.fromURL(url).mkString.length
}

val urls = List("http://www.opower.com",
                "http://www.amazon.com",
                "http://www.google.com",
                "http://www.sapient.com",
                "http://www.reddit.com")

def timeMethod(method: () => Unit) = {
  val start = System.nanoTime
  method()
  val stop = System.nanoTime
  
  println("Method took " + (stop - start)/1000000000.0 + " seconds.")
}

def getPageSizeSequentially() = {
  for(url <- urls) {
    println("Size for " + url + ": " + PageLoader.getPageSize(url))
  }
}

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

println("Sequential run: ")
timeMethod { getPageSizeSequentially }

println("Concurrent run: ")
timeMethod { getPageSizeConcurrently }