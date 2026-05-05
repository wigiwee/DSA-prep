class Solution {
    public int largestAltitude(int[] gain) {
        int prefixSum = 0;
        int maxAltitude = 0;
        for(int change  : gain){
            prefixSum = prefixSum + change;
            maxAltitude = Math.max(maxAltitude, prefixSum);
        }
        return maxAltitude;
    }
}
