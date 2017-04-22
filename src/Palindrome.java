
public class Palindrome {

	public static Deque<Character> wordToDeque(String word){
		int length = word.length();
		ArrayDeque<Character> wDeque = new ArrayDeque<Character>();
		for(int i = 0; i < length; i++){
			wDeque.addLast(word.charAt(i));
		}	
		return wDeque;
	}

/* Using recursion for wordToDeque
 * public static Deque<Character> wordToDeque(String word){
 * 		int length = word.length();
 * 		ArrayDeque<Character> wDeque = new ArrayDeque<Character>();
 * 		if (length=1){
 * 			return wDeque.addLast(word.charAt(length-1));
 * }
 * 		else
 * 			return???
 * 			
 * word.substring(a,b)
 * }
 */
	private static Deque<Character> wordReverseDeque(String word){
		int length = word.length();
		ArrayDeque<Character> rDeque = new ArrayDeque<Character>();
		for(int i = 0; i < length; i++){
			rDeque.addFirst(word.charAt(i));
		}	
		return rDeque;
	}
	
	public static boolean isPalindrome(String word){
		if (word.length() == 0 || word.length() == 1){
			return true;
		}
		Deque<Character> wDeque = new ArrayDeque<Character>();
		Deque<Character> rDeque = new ArrayDeque<Character>();
		wDeque = wordToDeque(word);
		rDeque = wordReverseDeque(word);
		int a = 0;
			for (int i = 0; i < word.length(); i++){
				if (wDeque.get(i) == rDeque.get(i)){
					a++;
				}
				if(a == word.length()){
					return true;
				}
			}
			return false;
	}
}
