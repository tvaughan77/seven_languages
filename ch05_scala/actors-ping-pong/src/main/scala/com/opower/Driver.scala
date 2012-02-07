package com.opower

import com.opower.pingpong._

object Driver {
  def main(args: Array[String]) {
    val pong = new Pong
    val ping = new Ping(100000, pong)
    ping.start
    pong.start
  }
}
