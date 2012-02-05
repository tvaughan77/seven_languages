package com.opower.ttt

/**
 * Represents a Tic-Tac-Toe board
 */
class Board(board: Array[Array[String]]) {
  
  override def toString() : String = { 
    board.deep.mkString("\n")
  }
  

}
