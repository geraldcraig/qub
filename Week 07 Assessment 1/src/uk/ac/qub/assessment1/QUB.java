
package uk.ac.qub.assessment1;

import java.util.Arrays;

/**
 * @author geraldcraig
 *
 */
public class QUB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String name;
		name = "QUB Computer Science"; // assume name will only ever contain 
		                               // Letters/Spaces (no punctuation etc)
									   // You can also assume it will start and 
		                               // end with letters (no trailing
									   // whitespace etc)
		// TODO : change name to upper case and output to screen.
		name = name.toUpperCase();
		System.out.println(name);

		// TODO : write a method which will count and return the number of occurrences
		// of a given character in a String.
		// Use it to output the number of spaces in name to the screen.

		// public static int occurrences(String input, char ch) {
		// counter for occurences of characters
		// int count = 0;
		// for loop to iterate through String
		// for (int i =0; i < name.length(); i++) { //if statement to look for character
		// if
		// }
		// (name(i).equals(" ")) { //add to count count++; } }

		// }

		// TODO : output to screen the total number of words in the input String name
		// i.e. 3 for "QUB Computer Science".
		// System.out.println(name.length);
		// TODO : replace QUB in name with QUEENS UNIVERSITY BELFAST and output the
		// String to screen.

		// TODO : output the total number of vowels in name to the screen (a, e, i, o,
		// u) -
		// both upper and lowercase occurrences should be counted.

		// TODO : output a sorted version of the sentence in ascending order by
		// character to screen.
		// Note space characters will normally be sorted in ascending order before
		// Alphabetic characters.
		String[] myName = name.split(" ");
		Arrays.sort(myName);
		System.out.println(Arrays.toString(myName));

	}
}
