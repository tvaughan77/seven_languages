package com.opower

/**
 * Use foldLeft to compute the total size of a list of strings
 */
object FoldLeft {

  def main(args: Array[String]) {
    if(args != null && !args.isEmpty) {

      val totalSize = computeTotalSizeOfStringArray(args)

      println("The total size of these strings: '" + args.mkString + "' is " + totalSize)
    }
    else {
      println("You are wasting my time calling me with no arguments!")
    } 
  }

  
  def computeTotalSizeOfStringArray(strings: Array[String]): Int = {
    if(strings == null) 
      0 
    else 
      (0 /: strings) {(total_size, string) => total_size + string.size}
  }
}
