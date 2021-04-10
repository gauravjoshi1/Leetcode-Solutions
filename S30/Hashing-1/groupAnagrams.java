/*
	Time Complexity: O(n * klogk): N when we iterate over N elements from string. k * logk for sorting characters with size k.
	Space Complexity: O(n* k) N elements with average character size k.
*/



class Solution {
	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> anagramMap = new HashMap<>();
		ArrayList<String> anagramVal = new ArrayList<>();
		
		for (String str : strs) {
			String sortedString = sortString(str);
			
			if (!anagramMap.containsKey(sortedString)) {
				anagramMap.put(sortedString, new ArrayList<>());
			}
			
			anagramMap.get(sortedString).add(str);
		}
		
		return new ArrayList<>(anagramMap.values());
	}
	
	private String sortString(String str) {
		char[] strArr = str.toCharArray();
		Arrays.sort(strArr);
		
		return String.valueOf(strArr); 
	}
}