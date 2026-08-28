class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;

        if(n == 1) return nums[0];
        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);

        for(int ind = 2; ind < n; ind++)
        {
            // Pick
            int pick = nums[ind] + prev2;

            // Not Pick
            int notPick = prev1;

            int curr = Math.max(pick, notPick);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
