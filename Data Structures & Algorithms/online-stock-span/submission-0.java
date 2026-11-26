class StockSpanner {
    public Deque<Integer> deck = new ArrayDeque<>();
    public Deque<Integer> deck2 = new ArrayDeque<>();
    
    public StockSpanner() {}
    
    public int next(int price) {
        deck.push(price);
        deck2 = new ArrayDeque<>(deck);
        int res = 0;

        while (deck2.peekFirst() != null && deck2.pollFirst() <= price) {
            res++;
        }

        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */