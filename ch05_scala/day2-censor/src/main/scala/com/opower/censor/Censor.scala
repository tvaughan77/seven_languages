package com.opower.censor

/**
 * A trait that replaces curse words with PG alternatives
 * 
 * For pedantic reasons, I made this trait extend a "RawString" class that's a thin wrapper around the final String class
 */
trait Censor extends RawString {

  abstract override def getContent() : String = {
    val rawContent = super.getContent()
//    dictionary.foreach
    rawContent
  }
  
  val defaultDictionary = Map("fucked" -> "messed",
                              "shitty" -> "unfortunate",
                              "nasty"  -> "Yoni's Mom-ish")
  
  def dictionary() : Map[String, String] = { defaultDictionary }
}
