package com.opower.ttt

import junit.framework._;
import Assert._;

object BoardTest {
    def suite: Test = {
        val suite = new TestSuite(classOf[BoardTest]);
        suite
    }

    def main(args : Array[String]) {
        junit.textui.TestRunner.run(suite);
    }
}


/**
 * Tests the Board class
 */
class BoardTest extends TestCase("board") {

    def testConstruction = {
      val board = new Board(Array.fill(3,3)(" "))
      assertNotNull(board)
      assertNotNull(board.toString)
      
      println(board.toString)
    }
    

}

