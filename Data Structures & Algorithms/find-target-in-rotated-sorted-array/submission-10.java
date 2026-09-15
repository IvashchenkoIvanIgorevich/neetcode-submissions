class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target)
                return m;

            if (nums[l] <= target && nums[m] > target) {
                r = m - 1;
            } else if (nums[l] > nums[m] && (nums[l] <= target || nums[m] > target)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}
