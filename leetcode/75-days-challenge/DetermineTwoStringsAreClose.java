class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;

        HashMap<Character, Integer> charMap1 = new HashMap<>();
        HashMap<Character, Integer> charMap2 = new HashMap<>();

        for(char ch : word1.toCharArray()) charMap1.put(ch, charMap1.getOrDefault(ch,0)+1);
        for(char ch : word2.toCharArray()) charMap2.put(ch, charMap2.getOrDefault(ch,0)+1);

        if(!charMap1.keySet().equals(charMap2.keySet())) return false;

        ArrayList<Integer> l1 = new ArrayList<>(charMap1.values());
        ArrayList<Integer> l2 = new ArrayList<>(charMap2.values());

        Collections.sort(l1);
        Collections.sort(l2);

        return l1.equals(l2);
    }
}
