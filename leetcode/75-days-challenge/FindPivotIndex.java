class Solution {
    public int pivotIndex(int[] nums) {
        int[] suffixSum = new int[nums.length];
        suffixSum[nums.length-1] = 0;
        for(int i = nums.length-2; i >=0; i--){
            suffixSum[i] = suffixSum[i+1] + nums[i+1];    
        }
        int preSum = 0;
        for(int i = 0; i < nums.length; i++){
            int prevDig = (i==0) ? 0 : nums[i-1];
            preSum += prevDig;
            if(preSum == suffixSum[i]) return i;
        }
        return -1;
    }
}
