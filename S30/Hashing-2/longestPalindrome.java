class Solution {
    public int longestPalindrome(String s) {
        HashSet<Integer> palindromeSet = new HashSet<>();
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
        	if (palindromeSet.contains(s.charAt(i)) {
        		palindromeSet.remove(s.charAt(i));		
        		count += 2;
        	} else {
        		palindromeSet.add(s.charAt(i));
        	}
        }
        
        return palindromeSet.isEmpty() ? count : count + 1;
    }
}