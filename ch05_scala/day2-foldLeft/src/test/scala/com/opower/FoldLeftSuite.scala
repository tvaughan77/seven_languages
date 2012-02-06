package com.opower

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.Assert._


/*
 * Tests for the FoldLeft class
 */
@RunWith(classOf[JUnitRunner])
class FoldLeftSuite extends FunSuite {

  test("total size of an array with one 3-letter word is 3") {
    assertEquals(3, FoldLeft.computeTotalSizeOfStringArray(Array("cat")))
  }
  
  test("total size of an array with five 5-letter words is 25") {
    assertEquals(25, FoldLeft.computeTotalSizeOfStringArray(Array("trunk", "chair", "gripe", "color", "canny")))
  }
  
  test("total size of a null array is 0") {
    assertEquals(0, FoldLeft.computeTotalSizeOfStringArray(null))
  }
  
  test("total size of an empty array is 0") {
    assertEquals(0, FoldLeft.computeTotalSizeOfStringArray(Array("")))
  }
}
