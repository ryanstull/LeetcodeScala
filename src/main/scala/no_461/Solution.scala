package no_461

/**
  * @author ryan
  * @since 9/3/17.
  */
object Solution {
	def main(args: Array[String]): Unit = {
		println(
			hammingDistance(255,0)
		)
	}

	def hammingDistance(x: Int, y: Int): Int = {
		def countBits(bits: Int,acc: Int): Int = {
			if(bits!=0){
				if(bits % 2 == 1) countBits(bits >> 1,acc+1)
				else countBits(bits >> 1,acc)
			}else acc
		}

		countBits(x ^ y,0)
	}
}
