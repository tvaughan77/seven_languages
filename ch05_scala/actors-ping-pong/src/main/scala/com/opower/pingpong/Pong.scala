package com.opower.pingpong

import scala.actors.Actor
import scala.actors.Actor._

case object Pong

class Pong extends Actor {
  def act() {
    var pongCount = 0
    while (true) {
      receive {
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