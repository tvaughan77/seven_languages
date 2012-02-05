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

    println(board.toString)
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
}