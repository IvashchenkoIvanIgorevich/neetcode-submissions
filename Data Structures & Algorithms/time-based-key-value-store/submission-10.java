class TimeMap {
    Map<String, Map<Integer, String>> vault;

    public TimeMap() {
        vault = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (vault.containsKey(key)) {
            vault.get(key).put(timestamp, value);
        } else {
            Map<Integer, String> n = new HashMap<>();
            n.put(timestamp, value);
            vault.put(key, n);
        }
    }

    public String get(String key, int timestamp) {
        Map<Integer, String> map = vault.get(key);
        if(map == null) return "";
        if (map.containsKey(timestamp)) return map.get(timestamp);

        int[] keys = map.keySet().stream().mapToInt(Integer::intValue).toArray();
        // if (keys.length == 1) {
        //     return keys[0] <= timestamp ? map.get(keys[0]) : "";
        // }
        Arrays.sort(keys);
        
        int l = 0;
        int r = keys.length - 1;
        while (l <= r) {
            int m = (l+r)/2;
            if(keys[m] >= timestamp) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        if (r < 0) return "";
        return keys[r] <= timestamp ? map.get(keys[r]) : "";
    }
}