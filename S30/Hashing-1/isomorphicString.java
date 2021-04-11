class Solution {
	public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
		
		HashMap<Character, Character> fMap = new HashMap<>();	
        HashMap<Character, Character> sMap = new HashMap<>();
		
		for (int i = 0; i < s.length(); i++) {
			if (fMap.containsKey(s.charAt(i))) {
				if (fMap.get(s.charAt(i)) != t.charAt(i)) {
					return false;
				}	
			} else if (sMap.containsKey(t.charAt(i))) {
				if (sMap.get(t.charAt(i)) != s.charAt(i)) {
					return false;
				}	
			} else {
				fMap.put(s.charAt(i), t.charAt(i)); 
				sMap.put(t.charAt(i), s.charAt(i)); 
			}
		}
        
		return true;
	}
}