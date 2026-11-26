class StockSpanner {
    public Deque<Integer> deck = new ArrayDeque<>();
    public Deque<Integer> deck2 = new ArrayDeque<>();
    
    public StockSpanner() {}
    
    public int next(int price) {
        deck.push(price);
        int res = 0;

        while (deck.peekFirst() != null && deck.peekFirst() <= price) {
            deck2.push(deck.pollFirst());
            res++;
        }

        while (deck2.peekFirst() != null) {
            deck.push(deck2.pollFirst());
        }

        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */