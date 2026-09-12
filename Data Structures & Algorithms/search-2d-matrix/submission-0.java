class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] arr : matrix) {
            int first = arr[0];
            int last = arr[arr.length - 1];

            if (target >= first && target <= last) {
                first = 0;
                last = arr.length - 1;

                while (first <= last) {
                    int middle = (last + first) /2 ;
                    if (target == arr[middle]) return true;

                    if (target > arr[middle]) {
                        first = middle + 1;
                    } else {
                        last = middle - 1;
                    }
                }
            }
        }
        return false;
    }
}
