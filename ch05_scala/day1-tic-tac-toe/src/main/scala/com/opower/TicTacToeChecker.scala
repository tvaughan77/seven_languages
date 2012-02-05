package com.opower

import com.opower.ttt._

/**
 * Hello world!
 *
 */
object TicTacToeChecker {

  def main(args: Array[String]) {
    val board = new Board(Array.fill(3,3)(CellState.BLANK))
    println("*****\n" + board + "\n*******")
  }
}
