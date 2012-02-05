package com.opower.ttt

import com.opower.ttt.CellState._

/**
 * Represents a Tic-Tac-Toe board
 */
class Board(state: Array[Array[CellState]]) {
  
  require(state.length == Board.DIM)
  require(state(0).length == Board.DIM)
  
  
  override def toString() : String = { 
    state.deep.mkString("\n")
  }
  
  def at(x: Int, y: Int) : CellState = state(x)(y)
  
    
  def anyRowWin(player: CellState) = {
    state exists (row => anyTrancheWin(player, row))
  }
  
  /*
   * True, if the tranche is size 3 and all elements are non-BLANK and the same as player
   */
  def anyTrancheWin(player: CellState, tranche: Array[CellState]) = {
    require(tranche.length == Board.DIM)
    require(player != CellState.BLANK)  // don't ask if "blank" wins
    tranche forall (_ == player)
  }
}


object Board {
  def DIM = 3;
  
  def blankBoard() : Board = new Board(Array.fill(DIM, DIM)(CellState.BLANK))
  
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
