package com.opower

import com.opower.ttt._
import scala.io.Source

/**
 * "Driver" class for reading in the state of a tic-tac-toe board and making a determination of whether or not any player
 * has won.
 * 
 * Usage:
 *   1) TicTacToeChecker -file <filename>
 *      where <filename> points to an ASCII text file containing 3 rows of 3 characters each of (X, O, or _)
 *      eg:
 *         X O _
 *         _ _ O
 *         X X X
 *         
 *   2) TicTacTorChecker -board <board pattern>
 *      where <boardpattern> is a quoted string of space-delimited "X", "O" or "_" characters
 *      eg:
 *         -board "X O _ _ _ O X X X"
 *
 */
object TicTacToeChecker {

  def main(args: Array[String]) {
    var boardStrings: Array[String] = null
    
    if(args != null && args.nonEmpty) {
      if(args(0).equals("-file")) {
        require(args(1) != null)
        boardStrings = parseBoardStringsFromFile(args(1))
      }
      else if(args(0).equals("-board")) {
        require(args(1) != null)
        boardStrings = args(1).split("[ ]")
      }
      else {
        println("Unknown initial argument " + args(0))
        exit(0)
      }
    } else {
      println("No [-file <file>] or [-board <X _ O ...>] input provided, assuming blank board")
      boardStrings = Array("_", "_", "_", "_", "_", "_", "_", "_", "_")
    }
    
    val board = Board.fromStrings(boardStrings:_*)
    
    println("Using this board: ")
    println("-------------------------------------------")
    println(board)
    println("-------------------------------------------")
    
    if(board.anyBoardWin(CellState.X)) {
      println("\n***\tPlayer X has won!\n\n")
    }
    else if(board.anyBoardWin(CellState.O)) {
      println("\n***\tPlayer O has won!\n\n")
    }
    
  }
  
  /*
   * Given a filename:
   * 1) open the file and get a List of the lines in that file
   * 2) add each element of the list to a string builder
   * 3) filter out the spaces
   * 4) convert the 
   */
  def parseBoardStringsFromFile(filename : String) : Array[String] = {
    val buffer = new StringBuilder
    Source.fromFile(filename).getLines.toList addString(buffer)          // We have something like buffer = "X _ OX O XO X _"
    buffer.filter(_ != ' ').toArray map {_.toString}                     // .toArray returns Array[Char], so cast it
  }
}
