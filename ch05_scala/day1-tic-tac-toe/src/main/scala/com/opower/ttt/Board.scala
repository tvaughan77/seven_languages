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
  
  
  /*
   * True, if any row in our state is considered to be a "winning tranche" (see {@code anyTrancheWin})
   */
  def anyRowWin(player: CellState) = {
    state exists (row => anyTrancheWin(player, row))
  }
  
  /*
   * True, if any column in our state is considered to be a "winning tranche" (see {@code anyTrancheWin})
   */
  def anyColWin(player: CellState) = {
    val inverse = Board.inverseMatrix(state)
    inverse exists(row => anyTrancheWin(player, row))
  }
  
  /*
   * True if either diagnoal in our state is considered to be a "winning tranche" (see {@code anyTrancheWin})
   */
  def anyDiagWin(player: CellState) = {
    val forwardSlash = Array(at(0,0), at(1,1), at(2,2))
    val backSlash = Array(at(0,2), at(1,1), at(2,0))
    
    anyTrancheWin(player, forwardSlash) || anyTrancheWin(player, backSlash)
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
  
  /**
   * Inverts a 2D matrix such that for every matrix[m][n] the resulting matrix contains the value at [n][m]
   * 
   * FIXME - how to make this generic with parameterized types and not assuming it's a nXn board ?
   */
  def inverseMatrix(matrix : Array[Array[CellState]]) : Array[Array[CellState]] = {
    val inverse = Array.fill(DIM, DIM)(CellState.BLANK)
    for(i <- 0 until matrix.length) {
      for(j <- 0 until matrix.length) {
        inverse(i)(j) = matrix(j)(i)
      }
    }
    inverse
  }
}
