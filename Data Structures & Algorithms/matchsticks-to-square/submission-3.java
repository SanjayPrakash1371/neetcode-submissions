class Solution {

    public boolean findNoOfSubsets(int currPos, int sumCarried,int sidesFormed, int[] matchsticks, int n, int[] vis, int squareSide)
    {

        if(sumCarried == squareSide)
        {
            sidesFormed = sidesFormed+1;

            if(sidesFormed == 4) return true;

            return findNoOfSubsets(0,0,sidesFormed , matchsticks, n, vis, squareSide);
        }


        


        for(int ind = currPos; ind < n; ind++)
        {
            if(vis[ind] == 1) continue;

            vis[ind] = 1;


            boolean isFound = findNoOfSubsets(ind+1, sumCarried + matchsticks[ind], sidesFormed, matchsticks,n,vis, squareSide);

            if(isFound) return true;

            vis[ind] = 0;

        }

        return false;


        

    }

    public boolean makesquare(int[] matchsticks) {
        

        int n = matchsticks.length;

        int totalSum = 0;

        for(int i : matchsticks){
            totalSum+=i;
        }

        if(totalSum % 4 !=0) return false;


        int squareSide = totalSum / 4;

        Arrays.sort(matchsticks);

        int[] vis = new int[n];

        boolean solved = findNoOfSubsets(0,0, 0, matchsticks, n, vis,squareSide );

        System.out.println(solved);

        return solved;
    }
}

// Imp plan
// total sum 
// sum / 4
// check is pos or not

// find no of subset eq to sq side sum

// if count = 4, reutrn true, else false;

// simpley we can say calulate the sum 
// div by 4
// we can get what each side should have
// if div bby 4 , gives !=0 return false

// If yes , find no of subsets with sum eq to sq side



// squ will have 4 sides
// so we need to make 4 equal sides
// we need to use all the match stick , we cant break it

// if n = 4 , each side one tick
// if n < 4 not possible

// if n > 4 , 
// if n = 5 , 3 sides 1 stick and ||. 1 side 2 sticks 

// [1,3,4,2,2,4]
// we need to use this arrays , and split it into 4 subsets with equal sum
// also we can take a element only once 

// 4/4 = 0
// 6/4 = 1-2 side each
// 8/4 = 2-3, each side 
// 12/4 = 3-4 side each

