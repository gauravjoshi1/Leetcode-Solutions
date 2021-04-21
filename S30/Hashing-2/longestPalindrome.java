// Time Complexity: O(n) [n is the length of string s]
// Space Complexity: O(1) [we only have 26 characters in hashset]

/*

Example input: s = "abccccdd"

Part 1: Logic:
	We create a hashset of characters in string s.
	Check if a character is present in the set. 
		if present: remove it add count + 2. 
		if not: add the character to set
	If set is not empty count + 1 [because we can have exactly 1 char that's not even]

Part 2: Example Walkthrough: 
	String s = "abccccdd"
	
	is a present in set? No. So add it.
	is b present in set? No. So add it.
	is c present in set? No. So add it.
	is c present in set? Yes. So remove it from set. count = 2
	is c present in set? No. So add it.
	is c present in set? Yes. So remove it from set. count = 4
	is d present in set? No. So add it.
	is d present in set? Yes. So remove it from set. count = 6
	
	is the set empty? No. count = 7.
*/

class Solution {
    public int longestPalindrome(String s) {
        if (s.length == 0) return 0;
        
        HashSet<Character> palindromeSet = new HashSet<>();
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
        	if (palindromeSet.contains(s.charAt(i))) {
        		palindromeSet.remove(s.charAt(i));		
        		count += 2;
        	} else {
        		palindromeSet.add(s.charAt(i));
        	}
        }
        
        return palindromeSet.isEmpty() ? count : count + 1;
    }
}