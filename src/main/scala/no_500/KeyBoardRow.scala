package no_500

/**
  * @author ryan
  * @since 9/3/17.
  */
object KeyBoardRow {

	def main(args: Array[String]): Unit = {
		val strings = Array("Hello", "Alaska", "Dad", "Peace")

		println(findWords(strings).toList)
	}

	def findWords(words: Array[String]): Array[String] = {
		val row1 = "qwertyuiop"
		val row2 = "asdfghjkl"
		val row3 = "zxcvbnm"

		words.filter { w =>
			val lower = w.toLowerCase
			lower.forall(row1.contains(_)) ||
				lower.forall(row2.contains(_)) ||
				lower.forall(row3.contains(_))
		}
	}
}
