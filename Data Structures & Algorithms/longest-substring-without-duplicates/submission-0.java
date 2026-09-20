class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> r = new HashSet<>();
        int res = 0;
        char[] c = s.toCharArray();
        for(int i = 0; i < c.length;i++) {
            int count = 0;
            int j = i;
            while(j < c.length) {
                if(r.contains(c[j])){
                    break;
                }
                r.add(c[j]);
                count++;
                j++;
            }
            res = Math.max(count,res);
            r.clear();
        }
        return res;
    }
}
