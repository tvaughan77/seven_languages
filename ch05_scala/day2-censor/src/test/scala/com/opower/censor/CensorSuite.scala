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
    assertEquals("Hello, messed up world!", censoredString.getContent)
  }
  
  test("Multiple cursing gets double filtered") {
    val censoredString = new CensoredString("This shitty beef stroganoff smells nasty!")
    assertEquals("This unfortunate beef stroganoff smells Yoni's Mom-ish!", censoredString.getContent)
  }
  
  test("Double cursing of the same word still gets filtered") {
    val censoredString = new CensoredString("Today is shitty and tomorrow will be shitty too")
    assertEquals("Today is unfortunate and tomorrow will be unfortunate too", censoredString.getContent)
  }
}
