class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        for(int i = 0 ; i < n; i++){
            int prevPrefix = (i==0) ? 1 : prefix[i-1];
            int prevNums = (i==0) ? 1 : nums[i-1];

            int oppIdx = n-1-i;
            int nextSuffix = (oppIdx == n-1) ? 1: suffix[oppIdx+1];
            int nextNum = (oppIdx == n-1) ? 1: nums[oppIdx+1];
            
            prefix[i] = prevPrefix * prevNums;
            suffix[oppIdx] = nextSuffix * nextNum;
        }
        for(int i = 0 ; i < n; i++){
            output[i] = prefix[i] * suffix[i];
        }
        return output;
    }
}
