class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] result = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2)).toArray();
        Arrays.sort(result);

        if((result.length % 2) != 0) {
            int m = result.length / 2;
            return result[m];   
        } else {
            int m = (result.length - 1) / 2;
            int mNext = m + 1;
            return (double)(result[m] + result[mNext]) / 2;
        }
    }
}// 1,2,3,4