class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int num: arr){
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }
        HashSet<Integer> freq = new HashSet<>();
        for(int num: freqMap.values()){
            if(freq.contains(num)) return false;
            freq.add(num);
        }
        return true;
    }
}
