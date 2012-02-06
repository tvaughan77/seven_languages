package com.opower.censor

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.Assert._


@RunWith(classOf[JUnitRunner])
class CensoredStringWithCustomDictionarySuite extends FunSuite {

  test("Basic censored string with custom dictionary suite testing") {
    val censoredString = new CensoredStringWithCustomDictionary("Hello, fucked up world!")
    assertEquals("Hello, jacked up world!", censoredString.getContent)
  }
}
