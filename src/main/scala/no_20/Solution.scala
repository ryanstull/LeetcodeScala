package no_20

import java.util.NoSuchElementException

/**
  * @author ryan
  * @since 9/3/17.
  */
object Solution {

	def main(args: Array[String]): Unit = {
		print(isValid("{}(())[()[]]"))
	}

	def isValid(s: String): Boolean = {
		val stack = scala.collection.mutable.Stack[Char]()

		try {
			s.iterator.foreach {
				case '(' => stack.push('(')
				case '[' => stack.push('[')
				case '{' => stack.push('{')
				case ')' => if (stack.pop() != '(') return false
				case ']' => if (stack.pop() != '[') return false
				case '}' => if (stack.pop() != '{') return false
				case _ =>
			}
		} catch {
			case _: NoSuchElementException => return false
		}

		stack.isEmpty
	}
}
