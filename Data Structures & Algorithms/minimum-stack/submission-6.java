class MinStack {
    private int size = 0;
    private int[] arr = new int[0];
    private int[] mins = new int[0];

    public MinStack() {}
    
    public void push(int val) {
        size++;
        arr = resize(arr);
        mins = resize(mins);

        if (size == 1) {
            mins[size-1] = val;
        } else {
            if (mins[size-2] >= val) {
                mins[size-1] = val;
            } else {
                mins[size-1] = mins[size-2];
            }
        }

        arr[size-1] = val;
    }
    
    public void pop() {
        size--;

        arr = resize(arr);
        mins = resize(mins);
    }
    
    public int top() {
        return arr[size-1];
    }
    
    public int getMin() {
        return mins[size-1];
    }

    // grows to current size
    private int[] resize(int[] a) {
        int[] new_arr = new int[size];
        return Arrays.copyOf(a, size);
    }
}
