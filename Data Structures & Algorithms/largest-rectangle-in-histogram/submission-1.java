class Solution {
    class Pair
    {
        int index;
        int value;

        Pair(int index, int value)
        {
            this.index = index;
            this.value = value;
        }
    }
    public int largestRectangleArea(int[] heights) {
        // Optimal Version

        Stack<Pair> stack = new Stack<>();

        // if the previous number (top) is smaller , its the pse , we yet to find the nse 
        // so add it into the stack

        // else the current number is the nse for the stack top 
        // So pop the stack top

        // the next stack top is pse for the last one
        // find the area , update the max 

        int n = heights.length;

        int maxArea = 0;

        for(int i = 0; i < n; i++)
        {

            while(!stack.isEmpty() && stack.peek().value  > heights[i])
            {
                int nse = i;
                int value = stack.pop().value;
                int pse = stack.isEmpty() ? -1 : stack.peek().index;

                int area = (nse - pse - 1) * value;

                maxArea = Math.max(maxArea, area);
            }
            stack.push(new Pair(i, heights[i]));
    
        }

        while(!stack.isEmpty())
        {
            int nse = n;
            int value = stack.pop().value;
            int pse = stack.isEmpty() ? -1 : stack.peek().index;

            int area = (nse - pse - 1) * value;

            maxArea = Math.max(maxArea, area);

        }

        return maxArea;

        
    }
}
