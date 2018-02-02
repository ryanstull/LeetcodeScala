package no_268

/**
  * @author ryan
  * @since 9/3/17.
  */
object MissingNumber {

	def main(args: Array[String]): Unit = println {
		missingNumber(Array(0,1,3,4,5,6,7))
	}

	def missingNumber(nums: Array[Int]): Int = {
		val n = nums.length
		
		(n*n + n) / 2 - nums.sum
	}
}
