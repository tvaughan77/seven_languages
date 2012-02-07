package com.opower.pingpong.receive

import scala.actors.Actor
import scala.actors.Actor._
import com.opower.pingpong.Stop

case object Ping

class Ping(count: Int, pong: Actor) extends Actor {
  def act() {
    
    var pingsLeft = count - 1
    pong ! Ping
    
    while (true) {
    
      receive {                       // This is thread blocking
      
        case Pong =>
        
          if (pingsLeft % 1000 == 0)
            println("Ping: pong")
          
          if (pingsLeft > 0) {
            pong ! Ping
            pingsLeft -= 1
          
          } else {
            println("Ping: stop")
            pong ! Stop
            exit()
          }
    
      }
    
    }
  }
}