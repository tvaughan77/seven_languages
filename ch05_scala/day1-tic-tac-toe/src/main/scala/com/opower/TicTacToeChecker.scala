package com.opower

import com.opower.ttt.Board

/**
 * Hello world!
 *
 */
object TicTacToeChecker {

  def main(args: Array[String]) {
    val board = new Board(Array.fill(3,3)(" "))
    println("*****\n" + board + "\n*******")
  }
}
