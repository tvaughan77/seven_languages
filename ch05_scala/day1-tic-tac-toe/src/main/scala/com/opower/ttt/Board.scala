package com.opower.ttt

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
  
  def at(x: Int, y: Int) : CellState = board(x)(y)
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
    
    // cells.grouped(DIM) turns a 9-length CellState array into an Iterator[List[CellState]] (where each list is size = 3)
    // iterator.toArray turns the Iterator into an array, so now we've got type Array[List[CellState]]
    // then we map the Array[List[CellState]] to the .toArray method to get our expected type of Array[Array[CellState]]
    cells.grouped(DIM).toArray map (_.toArray)
  }
}
