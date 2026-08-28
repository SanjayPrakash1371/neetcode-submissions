class Solution {
    public int findMinCost(int ind, int[] cost, int n)
    {
        // Base case
        if(ind >= n) return 0;

        int oneStep = cost[ind] + findMinCost(ind+1, cost, n);

        int twoStep = cost[ind] + findMinCost(ind+2, cost, n);

        return Math.min(oneStep, twoStep);

    }
    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;

        // return Math.min(findMinCost(0,cost, n), findMinCost(1,cost, n));

        int[] dp = new int[n+2];

        for(int ind = n-1; ind >=0; ind--)
        {
            int oneStep = cost[ind] + dp[ind+1];

            int twoStep = cost[ind] + dp[ind+2];

            dp[ind] =  Math.min(oneStep, twoStep);
        }

        return Math.min(dp[0], dp[1]);
        
        // int[] dp = new int[n+1];
        // dp[0] = cost[0];
        // dp[1] = cost[1];

        // for(int ind = 2; ind < n; ind++)
        // {
        //     dp[ind] = cost[ind] + Math.min(dp[ind-1], dp[ind-2]);
        // }
        // System.out.println(Arrays.toString(dp));
        // return dp[n];

    }
}
