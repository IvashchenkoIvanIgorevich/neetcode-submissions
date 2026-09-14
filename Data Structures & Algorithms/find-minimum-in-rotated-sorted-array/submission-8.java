class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        int l = 0;
        int r = nums.length - 1;

        while ((r - l) != 1) {
            int m = (l+r)/2;
            if (nums[l] < nums[m] && nums[m] < nums[r]) {
                r= m;
            } else if (nums[m] < nums[r]) {
                r=m;
            } else {
                l=m;
            }
        }
        return nums[l] > nums[r] ? nums[r] : nums[l];
    }
}
// 3,4,5,6,1,2


