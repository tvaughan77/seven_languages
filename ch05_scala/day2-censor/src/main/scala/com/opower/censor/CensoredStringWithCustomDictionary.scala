package com.opower.censor

import scala.io.Source

/**
 * Just like CensoredString, but provides its own dictionary to do the curse-word-filtering
 */
class CensoredStringWithCustomDictionary(override val content:String) extends RawString(content) with Censor {
  
  private val censorshipDictionaryFile: String = "custom_dictionary.txt"

  override def dictionary() : Map[String, String] = { 
    val myDictionary = scala.collection.mutable.Map[String, String]()
    
    val dictList = Source.fromFile(censorshipDictionaryFile).getLines.toList
    dictList.foreach{(line) => 
      val entries: Array[String] = line.split(" => ")
      myDictionary.put(entries(0).trim, entries(1).trim)
    }
    
    myDictionary.toMap     // .toMap to convert from mutable (needed during construction) to immutable
  }  

}
