package com.opower.censor

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.Assert._


@RunWith(classOf[JUnitRunner])
class RawStringSuite extends FunSuite {

  test("Basic raw string testing") {
    val rawString = new RawString("hello world")
    assertEquals("hello world", rawString.getContent)
  }
}
