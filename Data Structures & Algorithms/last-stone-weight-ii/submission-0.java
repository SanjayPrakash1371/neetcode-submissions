class Solution {



    public int lastStoneWeightII(int[] stones) {
        
        int n = stones.length;

        int totalSum = 0;

        for(int i : stones) totalSum+=i;

        boolean[][] dp = new boolean[n][totalSum+1];

        // for all index , if target is 0, we can make that sum
        for(int i = 0; i < n; i++)
        {
            dp[i][0] = true;
        }

        dp[0][stones[0]] = true;

        for(int i = 1; i < n; i++)
        {
            for(int target = 1; target <= totalSum; target++)
            {
                boolean pick = false;

                if(stones[i] <= target)
                {
                    pick = dp[i-1][target - stones[i]];
                }

                boolean notPick = dp[i-1][target];

                dp[i][target] = pick | notPick;
            }
        }

        int halfSum = totalSum/2;

        for(int highestPartSum = halfSum ; highestPartSum <= totalSum; highestPartSum++)
        {
            if(dp[n-1][highestPartSum] == true)
            {
                int lowestPart = totalSum - highestPartSum;
                int diff = highestPartSum - lowestPart;

                return Math.abs(diff);
            }
        }

        return 0;

    }
}

// Imp plan
// do the tabulation approach to check what are all the sum possible with this stones
// iterate from sum/2 
// find another part sum
// find the diff and take the min diff


// find the sum which is equal to sum/2 or slightly greater than sum/2
// if there is posibilit
// find another part sum
// find the diff and take the max diff

// we can see than smashing stones closer to each other gives min result
// so we need to do something like that
// 1,2
// 3,4
// 5,6

// if we can break the array into two subsets with same sum
// we can cancel out each and make it as 0
// if not , we can make two subsets of two sum which are closest to the sum / 2
// it will give the smallest left stone



// we can choose any stones and smash them
// if x <= y
// x == y, both stones are destroyed
// x!=y the stone of weight x os destroyed
// y will be y - x

// we need to play untill only one stones is left
// the left stone must be as small as possible


// we need to manipulate the array
// but we cant 

// can I use some thing as vis
// to keep track of the deleted ones
// so atlast only one left i can go with that
// this is not a good approach
