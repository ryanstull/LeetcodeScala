package no_513

/**
  * @author ryan
  * @since 9/4/17.
  */
object FindBottomLeftTree {

	def main(args: Array[String]): Unit = {
		val x = TreeNode(2)
		x.left = TreeNode(1)
		x.right = TreeNode(3)

		println{
			findBottomLeftValue(x)
		}
	}

	def findBottomLeftValue(root: TreeNode): Int = {

		def findBottomLeftRec(node: TreeNode, depth: Int): (Int,Int) = {

			def getResIfNotNull(n: TreeNode) =
				if (n != null) Some(findBottomLeftRec(n,depth+1))
				else None

			val leftRes = getResIfNotNull(node.left)

			val rightRes = getResIfNotNull(node.right)

			(leftRes,rightRes) match {
				case (None,None) => (node.value,depth)
				case (None,Some(r)) => r
				case (Some(l),None) => l
				case (Some(l),Some(r)) => l._2 - r._2 match {
					case i if i < 0 => r
					case _ => l
				}
			}
		}

		findBottomLeftRec(root,0)._1
	}

	case class TreeNode(value: Int) {
		var left: TreeNode = _
		var right: TreeNode = _
	}
}
