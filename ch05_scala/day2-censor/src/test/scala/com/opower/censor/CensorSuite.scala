package com.opower.censor

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.Assert._


@RunWith(classOf[JUnitRunner])
class CensorSuite extends FunSuite {

  test("Basic censor suite testing") {
    val basicString = new RawString("Hello, fucked up world!")
    assertEquals("Hello, fucked up world!", basicString.getContent)
    
    val censoredString = new CensoredString("Hello, fucked up world!")
    assertEquals("Hello, messed up world", censoredString.getContent)
  }
}
