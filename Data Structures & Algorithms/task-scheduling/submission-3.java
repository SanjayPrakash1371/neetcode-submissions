class Solution {
    class Pair
    {
        char ch;
        int freq;
        int nextAvailPos;

        Pair(char ch, int freq, int nextAvailPos)
        {
            this.ch = ch;
            this.freq = freq;
            this.nextAvailPos = nextAvailPos;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        
        PriorityQueue<Pair> maxFreq = new PriorityQueue<>((a,b)->Integer.compare(b.freq,a.freq));

        PriorityQueue<Pair> minFreq = new PriorityQueue<>((a,b)->Integer.compare(a.nextAvailPos,b.nextAvailPos));

        // Calculate the freq of each tasks

        HashMap<Character,Integer> freqMap = new HashMap<>();

        for(char ch : tasks)
        {
            freqMap.put(ch, freqMap.getOrDefault(ch,0)+1);
        }


        // Add everything into the maxFreq 

        for(char key : freqMap.keySet())
        {
            maxFreq.add(new Pair(key,freqMap.get(key),0));
        }

        // Perform until you have something in maxFreq 

        // Everthing present in MaxFreq is available
        int pos = 1;

        while(minFreq.size() > 0 || maxFreq.size() > 0)
        {
            // is available
            while(!minFreq.isEmpty() && minFreq.peek().nextAvailPos <= pos){
                maxFreq.add(minFreq.poll());
            }

            if(maxFreq.size() > 0){
                // Take the one wiht MaxFreq , reduce the freq and push it to the minHeap
                Pair pair = maxFreq.poll();
                pair.freq = pair.freq - 1;
                pair.nextAvailPos = pos + n + 1;

                if(pair.freq > 0){
                    minFreq.add(pair);
                }
            }
            

            pos++;
        }

        return pos-1;


    }
}

// Take two heap

// One is calculate the freq of each chars 
// Next one is to keep the taks which are idle 


// Becase if one has high freq , so than we cant use it again and again until its cooldown
// Also we cant place the only based on the last used pos 
// if multiple are there we need the one with max freq 

// we need to make the most freq is used when ever , it is  possible , then ony we can reduce the idle count
