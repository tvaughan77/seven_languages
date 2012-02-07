package com.opower.sizer

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.Assert._
import scala.xml._


/*
 * Tests for the SizerLeft class
 */
@RunWith(classOf[JUnitRunner])
class SizerSuite extends FunSuite {

  
  test("counting a string with no hrefs returns 0") {
    val html = <div>foo bar lorem ipsum</div>         // this is type scala.xml.Elem.  Could also use XML.loadString(string)
    assertEquals(0, PageLoader.countHrefsInLine(html))
  }
  
  test("counting a string with 1 href returns 1") {
    val html = <span>foo bar <a href="blah">my link</a> lorem ipsum</span>
    assertEquals(1, PageLoader.countHrefsInLine(html))
  }
  
  test("count a string with 3 hrefs returns 3") {
    val html = 
      <html>
      <body>
        <ul>
          <li><a href="http://www.google.com">This is a link to google</a></li>
          <li><a href="http://www.opower.com">This is a link to opower</a></li>
          <li><a href="http://www.aarf.com">This is a link to razorfish</a></li>
        </ul>
      </body>
      </html>
    assertEquals(3, PageLoader.countHrefsInLine(html))
  }
  
  test("count the number of hrefs on a page") {
    val numLinks = PageLoader.getNumLinksOnPage("http://www.google.com")
    assertTrue(0 < numLinks)
    println("The number of anchor tags on google's homepage is " + numLinks)
  }
  
}
