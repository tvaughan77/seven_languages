package com.opower.ttt

//import CellState
import com.opower.ttt.CellState._

/**
 * Represents a Tic-Tac-Toe board
 */
class Board(board: Array[Array[CellState]]) {
  
  require(board.length == Board.DIM)
  require(board(0).length == Board.DIM)
  
  
//  private def anyColWin: Boolean {
//    
//  }
  
  override def toString() : String = { 
    board.deep.mkString("\n")
  }
  

}

object Board {
  def DIM = 3;
  
  def fromCells(cells: CellState*) : Board = new Board(convertCellsListTo2DimArray(cells: _*))
  
  def fromStrings(strings: String*) : Board = fromCells(stringsToCells(strings: _*): _*)
  

  /*
   * Converts a signle var-arg list of Strings into a {@code List} of {@code CellState}s
   */  
  private def stringsToCells(strings: String*) = {
    strings map (CellState.withName(_))
  }
  
  /*
   * Converts a single var-arg list of {@code CellState}s to a 2-D array of dimension Board.DIM x Board.DIM 
   */
  private def convertCellsListTo2DimArray(cells: CellState*) = {
    require(cells.length == DIM * DIM)
    
    val board = Array.fill(DIM, DIM)(CellState.BLANK)
    
    // TODO look in to using "range" instead (http://daily-scala.blogspot.com/2009/11/varargs.html)
    for(i <- 0 until DIM) {
      for(j <- 0 until DIM) {
        board(i)(j) = cells(i*DIM + j)
      }
    }
    
    board
  }
}
