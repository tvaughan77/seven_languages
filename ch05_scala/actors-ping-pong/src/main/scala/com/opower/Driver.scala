package com.opower

import com.opower.pingpong._

object Driver {
  def main(args: Array[String]) {
    /*
     * This version will use the actor "receive" method that involves Thread blocking
     */
    playPingPong_With_Receive()
  }
  
  def playPingPong_With_Receive() {
    import com.opower.pingpong.Stop
    import com.opower.pingpong.receive._
    
    val pong = new Pong
    val ping = new Ping(100000, pong)
    ping.start
    pong.start
  }
}
