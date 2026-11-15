class TimeMap {
    Map<String, List<Bundle>> store = new HashMap<>();

    public TimeMap() {}
    
    public void set(String key, String value, int timestamp) {
        if (!store.containsKey(key)) {
            List<Bundle> arr = new ArrayList<>(List.of(new Bundle(value, timestamp)));
            store.put(key, arr);
        } else {
            store.get(key).add(new Bundle(value, timestamp));
        }
    }
    
    public String get(String key, int timestamp) {
        if (!store.containsKey(key) || store.get(key).get(0).timestamp > timestamp) {
            return "";
        }

        List<Bundle> arr = store.get(key);

        int low = 0;
        int high = arr.size()-1;
        int hpta = 0; // highest price technically acceptable

        while (low <= high) {
            int midIdx = low + (high - low)/2;
            int mid = arr.get(midIdx).timestamp;

            if (mid > timestamp) {
                high = midIdx - 1;
            } else if (mid < timestamp) {
                hpta = midIdx;
                low = midIdx + 1;
            } else {
                return arr.get(midIdx).value;
            }
        }

        return arr.get(hpta).value;
    }


    static class Bundle {
        String value;
        int timestamp;

        Bundle(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}
