package com.opower.ttt

import org.scalatest.junit.JUnitSuite
import org.scalatest.junit.ShouldMatchersForJUnit
import scala.collection.mutable.ListBuffer
import org.junit.Test
import org.junit.Before
import org.junit.Assert._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite

@RunWith(classOf[JUnitRunner])
class BoardSuite extends FunSuite {
  
  test("happy path construction") {
    val board = new Board(Array.fill(3,3)(CellState.BLANK))
    assertNotNull(board)
    assertNotNull(board.toString)
  }
  
  
  // A tic-tac-toe board needs to be a 3x3 grid
  test("construction should fail when first array index isn't == 3") {
    intercept[IllegalArgumentException] {
      new Board(Array.fill(1, 3)(CellState.BLANK))
    }
  }
  
  // A tic-tac-toe board needs to be a 3x3 grid
  test("construction should fail when second array index isn't == 3") {
    intercept[IllegalArgumentException] {
      new Board(Array.fill(3, 99)(CellState.BLANK))
    }
  }
  
  test("construct a board with a vararg list of Strings") {
    val board = Board.fromStrings("X", "_", "O", "O", "X", "_", "O", "X", "_")
    println(board)
    assertEquals(CellState.X,     board.at(0, 0))
    assertEquals(CellState.BLANK, board.at(0, 1))
    assertEquals(CellState.O,     board.at(0, 2))
    assertEquals(CellState.O,     board.at(1, 0))
    assertEquals(CellState.X,     board.at(1, 1))
    assertEquals(CellState.BLANK, board.at(1, 2))
    assertEquals(CellState.O,     board.at(2, 0))
    assertEquals(CellState.X,     board.at(2, 1))
    assertEquals(CellState.BLANK, board.at(2, 2))
  }
  
  test("construct a board with invalid string representations of cells") {
    intercept[NoSuchElementException] {
      Board.fromStrings("A", "B", "C", "D", "E", "F", "G", "H", "I")
    }
  }
  
  test("construct a board with an invalid number of valid cell strings") {
    intercept[IllegalArgumentException] {
      Board.fromStrings("X", "_", "O")
    }
  }
  
  test("a tranche is considered winning if all elements in a tranche are the same, but not for the case of BLANKS") {
    val board = Board.blankBoard
    assertTrue(board.anyTrancheWin(CellState.X, Array(CellState.X, CellState.X, CellState.X)))
    assertTrue(board.anyTrancheWin(CellState.O, Array(CellState.O, CellState.O, CellState.O)))
    assertFalse(board.anyTrancheWin(CellState.O, Array(CellState.X, CellState.X, CellState.X)))
    assertFalse(board.anyTrancheWin(CellState.X, Array(CellState.O, CellState.O, CellState.O)))
    assertFalse(board.anyTrancheWin(CellState.X, Array(CellState.X, CellState.X, CellState.O)))
    assertFalse(board.anyTrancheWin(CellState.O, Array(CellState.X, CellState.O, CellState.O)))
  }
  
  test("it's an exception to ask if 'blank' is winning a trance") {
    val board = Board.blankBoard
    intercept[IllegalArgumentException] {
      board.anyTrancheWin(CellState.BLANK, Array(CellState.X, CellState.X, CellState.X))
    }
  }
  
  test("it's an exception to pass anything but a 3-element array to anyTrancheWin()") {
    val board = Board.blankBoard
    intercept[IllegalArgumentException] {
      board.anyTrancheWin(CellState.X, Array(CellState.X, CellState.X, CellState.O, CellState.O))
    }
  }
  
  test("anyRowWin with the 3rd row being in a winning state for player X") {
    val board = Board.fromStrings("_", "_", "O", "X", "O", "O", "X", "X", "X")
    assertTrue(board.anyRowWin(CellState.X))
    assertFalse(board.anyRowWin(CellState.O))
  }
}