package com.opower.pingpong.react

import scala.actors.Actor
import scala.actors.Actor._
import com.opower.pingpong.Stop

case object Ping

class Ping(count: Int, pong: Actor) extends Actor {
  def act() {
    
    var pingsLeft = count - 1
    println("Starting react-ping at " + System.nanoTime)
    pong ! Ping
    
    loop {
    
      react {
      
        case Pong =>
        
          if (pingsLeft % 10000 == 0)
            println("Ping: pong")
          
          if (pingsLeft > 0) {
            pong ! Ping
            pingsLeft -= 1
          
          } else {
            println("Ping: stop")
            pong ! Stop
            println("Stopping react-ping at " + System.nanoTime)
            exit()
          }
    
      }
    
    }
  }
}
