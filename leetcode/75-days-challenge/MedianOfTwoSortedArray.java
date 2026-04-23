class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int ptr1 = 0, ptr2 = 0;

        int total = n + m;
        int target = total / 2;

        int prev = 0, curr = 0;

        for (int count = 0; count <= target; count++) {
            prev = curr;

            if (ptr1 < n && (ptr2 >= m || nums1[ptr1] <= nums2[ptr2])) {
                curr = nums1[ptr1++];
            } else {
                curr = nums2[ptr2++];
            }
        }

        if (total % 2 == 0) {
            return (prev + curr) / 2.0;
        } else {
            return curr;
        }
    }
}
