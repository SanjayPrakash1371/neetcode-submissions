class KthLargest {

    PriorityQueue<Integer> pq;

    int k ;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k;

        for(int i : nums)
        {
            if(pq.size() < k)
            {
                pq.add(i);
            }
            else if(pq.peek() < i){
                pq.poll();
                pq.add(i);
            }
        }
    }
    
    public int add(int val) {

        if(pq.size() < k)
        {
            pq.add(val);
        }
        else if(pq.peek() < val){
            pq.poll();
            pq.add(val);
        }


        return pq.peek();

    

    }
}
// Create a min Heap to check the kth value 
// if its smaller than the current kth largest element 
// Use min heap to do it.