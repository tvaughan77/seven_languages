package com.opower.ttt

/**
 * A Cell is a spot on a Board and a CellState is whether or not the spot is an "X", "O" or blank 
 */
object CellState extends Enumeration {
  type CellState = Value
  val X = Value("X")
  val O = Value("O")
  val BLANK = Value("_")
}
