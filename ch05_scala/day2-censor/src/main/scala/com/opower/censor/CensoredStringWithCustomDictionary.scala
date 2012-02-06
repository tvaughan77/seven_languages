package com.opower.censor

/**
 * Just like CensoredString, but provides its own dictionary to do the curse-word-filtering
 */
class CensoredStringWithCustomDictionary(override val content:String) extends RawString(content) with Censor {
  


  val myDictionary = Map("fucked" -> "jacked",
                              "shitty" -> "rotten",
                              "nasty"  -> "Yoni's Mom-ish")
  
  override def dictionary() : Map[String, String] = { myDictionary }  

}
