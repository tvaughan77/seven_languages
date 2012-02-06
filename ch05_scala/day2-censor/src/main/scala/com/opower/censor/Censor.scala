package com.opower.censor

/**
 * A trait that replaces curse words with PG alternatives
 * 
 * For pedantic reasons, I made this trait extend a "RawString" class that's a thin wrapper around the final String class
 */
trait Censor extends RawString {

  abstract override def getContent() : String = {
    var censoredContent = super.getContent
    dictionary.foreach{ 
      (entry: (String, String)) => censoredContent = censoredContent.replace(entry._1, entry._2)
    }
    censoredContent
  }
  
  val defaultDictionary = Map("fucked" -> "messed",
                              "shitty" -> "unfortunate",
                              "nasty"  -> "Yoni's Mom-ish")
  
  def dictionary() : Map[String, String] = { defaultDictionary }
}
