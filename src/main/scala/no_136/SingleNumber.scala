package no_136

/**
  * @author ryan
  * @since 9/3/17.
  */
object SingleNumber {

	def main(args: Array[String]): Unit = println {
		singleNumber(Array(2,4,3,1,2,4,1))
	}

	def singleNumber(nums: Array[Int]): Int = nums.foldLeft(0)(_^_)
}
