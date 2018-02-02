package no_344;

/**
 * @author ryan
 * @since 9/4/17.
 */
public class ReverseString {

	public static void main(String[] args){
		System.out.println(reverseString("Hello"));
	}

	public static String reverseString(String s) {
		return new StringBuilder(s).reverse().toString();
	}
}
