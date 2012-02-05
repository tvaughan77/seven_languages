package com.opower.ttt

/**
 * Represents a Tic-Tac-Toe board
 */
class Board(board: Array[Array[String]]) {
  
  require(board.length == 3)
  require(board(0).length == 3)
  
  override def toString() : String = { 
    board.deep.mkString("\n")
  }
  

}
