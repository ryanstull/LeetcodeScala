package no_561

/**
  * @author ryan
  * @since 9/3/17.
  */
object ArrayPartition1 {

	def main(args: Array[String]): Unit = println {
		arrayPairSum(Array(3,1,1,5,2,2))
	}

	def arrayPairSum(nums: Array[Int]): Int = nums.sorted.sliding(2,2).map(_.min).sum
}
