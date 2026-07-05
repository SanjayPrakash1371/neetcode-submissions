/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        return findMinMeetingRooms2(intervals);
    }

    // Optimal Approach
    public int findMinMeetingRooms(List<Interval> intervals)
    {
        int n = intervals.size();
        if(n==0) return 0;

        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();

        for(Interval interval  : intervals)
        {
            start.add(interval.start);
            end.add(interval.end);
        }

        Collections.sort(start);
        Collections.sort(end);

        int endPtr = 0;
        int roomsNeeded=0;

        for(int startPtr = 0; startPtr < n; startPtr++)
        {
            // if the current meeting is starting before the current end Meeting
            if(start.get(startPtr) < end.get(endPtr)){
                roomsNeeded++;
            }
            else{
                endPtr++;
            }
        }

        return roomsNeeded;



    }

    // Priority Queue Approach
    public int findMinMeetingRooms2(List<Interval> intervals)
    {
        int n = intervals.size();
        if(n==0) return 0;

        List<Integer> start = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(Interval interval  : intervals)
        {
            start.add(interval.start);
            pq.add(interval.end);
        }

        Collections.sort(start);

        int roomsNeeded = 0;
        for(int startPtr = 0; startPtr < n; startPtr++)
        {
            
            if( start.get(startPtr) < pq.peek()){
                roomsNeeded++;
            }
            else{
                // the meeting is starting before the peek meeting end 
                // so no new room needed , so remove the peek meeting 
                pq.poll();
            }
        }

        return roomsNeeded;
    }
}
