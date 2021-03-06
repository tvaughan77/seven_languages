package com.opower.pingpong.react

import scala.actors.Actor
import scala.actors.Actor._
import com.opower.pingpong.Stop

case object Pong

class Pong extends Actor {
  def act() {
    var pongCount = 0
   
    loop {
    
      react {
        
        case Ping =>
          if (pongCount % 1000 == 0)
            println("Pong: ping "+pongCount)
          sender ! Pong
          pongCount = pongCount + 1
      
        case Stop =>
          println("Pong: stop")
          exit()
      }
      
    }
    
  }
}