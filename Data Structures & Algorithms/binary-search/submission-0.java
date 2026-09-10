class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = (right + left)/2;
            System.out.println("middle:" + middle);
            if (nums[middle] == target) return middle;

            if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
            System.out.println("left:" + left);
            System.out.println("right:" + right);
            System.out.println("============");
        }
        return -1;
    }
}

// step 1
// left, right
// step 2
// while loop - untill left<right
// step 3
// find middle index by left and right
// step 4
// equals middle with target - if equals -> return
// step 5
// if nums[middle] < target -> left == middle + 1
// if nums[middle] > target -> right == middle - 1
// if break from the loop -> return -1
