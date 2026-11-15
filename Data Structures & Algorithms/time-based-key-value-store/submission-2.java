class TimeMap {
    
    //  Alice , Happy
    Map<String, List<Bundle>> store = new HashMap<>();

    // want the timestamp that is largest that is still smaller or equal to than our request value

    public TimeMap() {}
    
    public void set(String key, String value, int timestamp) {
        if (!store.containsKey(key)) {
            List<Bundle> arr = new ArrayList<>();
            arr.add(new Bundle(value, timestamp));
            store.put(key, arr);
        } else {
            List<Bundle> existing = store.get(key);
            existing.add(new Bundle(value, timestamp));
        }
    }
    
    public String get(String key, int timestamp) {
        if (!store.containsKey(key)) {
            return "";
        }

        // if first is larger than given key
        if (store.get(key).get(0).timestamp > timestamp) {
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
