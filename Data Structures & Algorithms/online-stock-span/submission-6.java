class StockSpanner {
    public Deque<int[]> deck = new ArrayDeque<>();
    // K, V | val, span
    public StockSpanner() {}
    
    public int next(int price) {
        int span = 1;

        while (!deck.isEmpty() && deck.peek()[0] <= price) {
            span += deck.pop()[1];
        }
        deck.push(new int[] {price, span});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */