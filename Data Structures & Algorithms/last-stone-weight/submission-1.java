class Solution {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b,a));

        for(int i : stones)
        {
            pq.add(i);
        }

        while(pq.size() > 1)
        {
            int val1 = pq.poll();
            int val2 = pq.poll();

            if(val1 != val2)
            {
                val1 = val1-val2;
                pq.add(val1);
            }
        }

        return pq.size() > 0 ? pq.peek() : 0;

    }
}
// Add all the values in proprity queue 
// Do the simulation

// until. the size is 1