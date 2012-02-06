package com.opower.censor

class CensoredString(override val content:String) extends RawString(content) with Censor 
