package com.opower

object Driver {
  def main(args: Array[String]) {
    /*
     * This version will use the actor "receive" method that involves Thread blocking
     * This took 2.8 seconds -- and it has the advantage of getting a slight head start of the next method call
     */
    playPingPong_With_Receive
    
    /*
     * This version will use the actor "react" method that maximizes thread pool reuse
     * This took 1.7 seconds
     */
    playPingPong_With_React
  }
  
  def playPingPong_With_Receive() = {
    import com.opower.pingpong.receive._
    
    val pong = new Pong
    val ping = new Ping(100000, pong)
    ping.start
    pong.start
  }
  
  def playPingPong_With_React() = {
    import com.opower.pingpong.react._
    
    val pong = new Pong
    val ping = new Ping(100000, pong)
    ping.start
    pong.start
  }
}
