class Solution {
    public int findMax(int ind, int[] nums, int n)
    {
        // Base case
        if(ind == n) return nums[ind];

        if(ind > n) return 0;

        int pick = nums[ind] + findMax(ind+2, nums, n );

        int notPick = findMax(ind+1, nums, n);

        return Math.max(pick, notPick);
        

    }
    public int rob(int[] nums) {

        int n = nums.length;

        if(n==1) return nums[0];
        if(n==2 ) Math.max(nums[0],nums[1]);

        int pickLast = tabulation(nums, 1,n);

        int notPickLast = tabulation(nums, 0,n);
        // int notPickLast = 0;

        return Math.max(pickLast, notPickLast);
        
        
    }

    public int tabulation(int[] nums , int startIndex,int n)
    {
        int[] dp = new int[n];
        // Base case
        // if st = 0
        // if st = 1
        if(startIndex == 0){
            dp[n-1] = 0;
        }
        else{
            dp[n-1] = nums[n-1];
        }

        


        for(int ind = n-2; ind >=startIndex; ind--)
        {
            int pick = nums[ind];
            if(ind + 2 < n) pick+=dp[ind+2];

            int notPick = dp[ind+1];

            dp[ind] = Math.max(pick, notPick);
        }

        System.out.println(Arrays.toString(dp));

        return dp[startIndex];
    }
}
