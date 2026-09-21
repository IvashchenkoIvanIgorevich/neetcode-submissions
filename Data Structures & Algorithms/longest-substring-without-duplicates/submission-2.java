class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> r = new HashSet<>();
        int res = 0;
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            int j = i;
            while (j < s.length()) {
                if (r.contains(s.charAt(j)))
                    break;

                r.add(s.charAt(j));
                count++;
                j++;
            }
            res = Math.max(res, count);
            r.clear();
        }
        return res;
    }
}