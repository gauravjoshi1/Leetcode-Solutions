class Solution {
    public boolean wordPattern(String pattern, String s) {
        char[] patternArr = pattern.toCharArray();
        String[] stringArr = s.split(" ");
        
        /* return false if the word length doesn't match */
        if (patternArr.length != stringArr.length) return false;
        
        HashMap<Character, String> letterToWord = new HashMap<>();
        HashMap<String, Character> wordToLetter = new HashMap<>();
        
       
        for (int i = 0; i < patternArr.length; i++) {
            if (letterToWord.containsKey(patternArr[i])) {
                if (!letterToWord.get(patternArr[i]).equals(stringArr[i])) {
                    return false;
                }
            }
            
            if (wordToLetter.containsKey(stringArr[i])) {
                if (!wordToLetter.get(stringArr[i]).equals(patternArr[i])) {
                    return false;
                }
            }
            
            letterToWord.put(patternArr[i], stringArr[i]);
            wordToLetter.put(stringArr[i], patternArr[i]);
        }
        
        return true;
    }
}