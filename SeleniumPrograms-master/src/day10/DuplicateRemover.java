package day10;

import java.util.LinkedHashSet;
import java.util.Set;


/*Convert the string to an array of char, and store it in a LinkedHashSet. 
 * That will preserve your ordering, and remove duplicates.
*/
public class DuplicateRemover {

	public static void main(String[] args) {
		
		String string = "aabbbc";

		char[] chars = string.toCharArray();
		Set<Character> charSet = new LinkedHashSet<Character>();
		
		for (char c : chars) {
		    charSet.add(c);
		}
		
		StringBuilder sb = new StringBuilder();
		for (Character character : charSet) {
		    sb.append(character);
		}
		System.out.println(sb.toString());
	}
}


