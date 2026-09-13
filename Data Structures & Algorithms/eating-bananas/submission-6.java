class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int p : piles) {
            right = Math.max(right, p);
        }

        while(left <= right) { // TODO
            
            int middle = (left + right) / 2;
            int rate = getHours(piles, middle);

            if (rate > h) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return left;
    }

    private int getHours(int[] piles, int middle) {
        int result = 0;
        
        for(int i:piles) {
            result += (int) Math.ceil((double) i / middle);
        }
        return result;
    }
}