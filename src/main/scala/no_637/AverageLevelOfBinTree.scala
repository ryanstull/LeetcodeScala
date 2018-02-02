package no_637

import scala.collection.mutable

/**
  * @author ryan
  * @since 9/8/17.
  */
object AverageLevelOfBinTree {

	def main(args: Array[String]): Unit = {
		val a = new TreeNode(2)
		val b = new TreeNode(3)
		val c = new TreeNode(4)

		val d = new TreeNode(10)
		val e = new TreeNode(13)

		a.left = b
		a.right = c

		c.left = d
		b.right = e

		time{
			averageOfLevels(a)
		}
	}

	def averageOfLevels(root: TreeNode): Array[Double] = {

		implicit class MutableMapUtils[K,X](xs: mutable.Map[K,List[X]]) {
			def merge(ys: mutable.Map[K, List[X]]): mutable.Map[K, List[X]] = {
				ys.foreach { y =>
					xs(y._1) = if (!xs.contains(y._1)) y._2 else y._2 ::: xs(y._1)
				}
				xs
			}
		}

		def getMapForNode(root: TreeNode,depth: Int): mutable.Map[Int,List[Double]] = {

			val thisNode = mutable.Map(depth -> List(root.value.toDouble))

			thisNode merge( (root.left,root.right) match {
				case (null,null) => mutable.Map.empty[Int,List[Double]]
				case (l,null) => getMapForNode(l,depth+1)
				case (null,r) => getMapForNode(r,depth+1)
				case (l,r) => getMapForNode(l,depth+1) merge getMapForNode(r,depth+1)
			})
		}

		getMapForNode(root, 0).toArray.sortBy(_._1).map{ t =>
			t._2.sum / t._2.size
		}
	}

	def time[R](r: => R): R = {
		val start = System.currentTimeMillis()
		val res = r
		val end = System.currentTimeMillis()
		println(s"Time is ${end-start}")
		res
	}

}

class TreeNode(var _value: Int) {
	var value: Int = _value
	var left: TreeNode = _
	var right: TreeNode = _
}