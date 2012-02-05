package com.opower.ttt

//import CellState
import com.opower.ttt.CellState._

/**
 * Represents a Tic-Tac-Toe board
 */
class Board(board: Array[Array[CellState]]) {
  
  require(board.length == 3)
  require(board(0).length == 3)
  
  
  
  override def toString() : String = { 
    board.deep.mkString("\n")
  }
  

}
