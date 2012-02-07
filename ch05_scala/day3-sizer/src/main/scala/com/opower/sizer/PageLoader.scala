package com.opower.sizer

import scala.io.Source
import scala.xml._

/**
 * FIXME - the getPageInfo method ends up requesting the same web content twice because I can't shoe-horn a scala.io.Source
 * object into a scala.xml.package.InputSource object
 */
object PageLoader {
  
  private val adapter = new scala.xml.parsing.NoBindingFactoryAdapter
  private val parserFactory = new org.ccil.cowan.tagsoup.jaxp.SAXFactoryImpl
  
  def getPageInfo(url: String) = {
    (getPageSize(url), getNumLinksOnPage(url))
  }
  
  def getPageSize(url: String): Int = { scala.io.Source.fromURL(url).mkString.length }
  
  
  /**
   * It'd be nice to use the standard scala Source.fromURL(url).toLines and maybe parse each line into an XML Elem or Node, but
   * the URLs we may be visiting aren't all nice XML or even XHtml compliant.  The special parserFactory and XML parsing 
   * adapters used in this method are stolen from:
   * http://www.hars.de/2009/01/html-as-xml-in-scala.html
   * 
   * Curiously, this solution against google.com tells me there are 20 "a" tags wheres actually counting them in "view source"
   * in my chrome browser shows 44. Then again, when I wget google.com I only end up with 21 links, so I think they're doing
   * something on their side that makes double checking the results with a different browser kind of difficult.
   */
  def getNumLinksOnPage(url: String) = {
    val parser = parserFactory.newSAXParser()
    val source = new org.xml.sax.InputSource(url)
    
    countHrefsInLine(adapter.loadXML(source, parser))
  }
  
  
  /*
   * Returns an integer number of times that an {@code "<a>"} tags is encountered in {@code line}
   */
  def countHrefsInLine(line: Node) = (line \\ "a").length

}