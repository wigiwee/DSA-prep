class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if(n ==1 || n ==0 ) return;
        int corrIdx = 0;
        for(int i =0; i < n; i++){
            if(nums[i]!=0){
                nums[corrIdx++] = nums[i];
            }
        }
        while(corrIdx < n){
            nums[corrIdx++] = 0;
        }
    }
}
