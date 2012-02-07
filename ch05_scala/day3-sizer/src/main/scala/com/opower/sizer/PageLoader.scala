package com.opower.sizer

import scala.io.Source
import scala.xml.Elem

object PageLoader {
  def getPageSize(url: String) = scala.io.Source.fromURL(url).mkString.length
  
  def getNumLinksOnPage(url: String) = {
    val it = Source.fromURL(url).getLines
    
  }
  
  /*
   * Returns an integer number of times that an {@code "<a>"} tags is encountered in {@code line}
   */
  def countHrefsInLine(line: Elem): Int = {
    (line \\ "a").length
  }

}