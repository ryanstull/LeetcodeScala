package no_28

/**
  * @author ryan
  * @since 9/3/17.
  */
object Solution {

	def main(args: Array[String]): Unit = {
		println (strStr("Hello","o"))
	}

	def strStr(haystack: String, needle: String): Int = {
		haystack.indexOf(needle)
	}
}
