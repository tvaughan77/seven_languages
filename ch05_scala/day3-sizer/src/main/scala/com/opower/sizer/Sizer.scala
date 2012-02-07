package com.opower.sizer

import scala.io._

object PageLoader {
  def getPageSize(url: String) = Source.fromURL(url).mkString.length

}