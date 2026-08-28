class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;
        
        int[] dp = new int[n+1];

        dp[n-1] = cost[n-1];
        System.out.println(Arrays.toString(dp));


        for(int ind = n-2; ind >=0; ind--)
        {
            dp[ind] = cost[ind] + Math.min(dp[ind+1], dp[ind+2]);
        }
        System.out.println(Arrays.toString(dp));
        return Math.min(dp[0], dp[1]);

    }
}
