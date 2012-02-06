package com.opower.censor

/**
 * A class that extends the "RawString" class (which you can think about as the java.lang.String surrounded by a wrapper
 * class that returns you the String with a call to .getContent()
 * 
 * This class also uses the "Censor" mixin trait which intercepts any call to getContent() and replaces curse words with
 * tamer alternatives.
 */
class CensoredString(override val content:String) extends RawString(content) with Censor 
