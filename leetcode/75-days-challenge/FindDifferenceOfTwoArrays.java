class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> nums1Set = new HashSet<Integer>();
        HashSet<Integer> nums2Set = new HashSet<Integer>();

        for(int nums: nums1) nums1Set.add(nums);
        for(int nums: nums2) nums2Set.add(nums);

        ArrayList<Integer> nums1Uniq = new ArrayList<Integer>();
        ArrayList<Integer> nums2Uniq = new ArrayList<Integer>();

        for(int num : nums1Set) if(!nums2Set.contains(num)) nums1Uniq.add(num); 
        for(int num : nums2Set) if(!nums1Set.contains(num)) nums2Uniq.add(num);

        List<List<Integer>> output = new ArrayList<>();
        output.add(nums1Uniq);
        output.add(nums2Uniq);
        return output;
    }
}
