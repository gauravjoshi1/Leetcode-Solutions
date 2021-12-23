class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null | s.length() == 0) return 0;

        int start = 0;
        int maxLength = 0;
        HashMap<Character, Integer> mapStr = new HashMap<>();
        for (int end = 0; end < s.length(); end++) {
            mapStr.put(s.charAt(end), mapStr.getOrDefault(s.charAt(end), 0) + 1);

            if (mapStr.get(s.charAt(end)) > 1) {
                while (s.charAt(start) != s.charAt(end)) {
                    mapStr.remove(s.charAt(start));
                    start = start + 1;
                }

                mapStr.put(s.charAt(start), 1);
                start = start + 1;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
