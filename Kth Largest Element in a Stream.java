class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<Integer>(k);
        this.k = k;
        for (Integer num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        if (pq.size() < k) {
            pq.add(val);
        } else {
            if (pq.peek() < val) {
                pq.remove();
                pq.add(val);
            }
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */