class Solution {

    public void findAllPermutations(int currPos, int[] nums ,List<List<Integer>> result, int n)
    {
        // Base case 

        if(currPos == n){
            List<Integer> list = new ArrayList<>();
            for(int i : nums) list.add(i);
            result.add(list);
            return;
        }


        for(int ind = currPos; ind < n; ind++)
        {
            // swap
            swap(currPos, ind,nums);

            findAllPermutations(currPos+1, nums, result,n);


            // reswap
            swap(currPos, ind,nums);


        }
    }

    public void swap(int currPos, int ind, int[] nums)
    {
        if(currPos == ind) return;

        int temp = nums[currPos];
        nums[currPos] = nums[ind];
        nums[ind] = temp;
    }
    

    public List<List<Integer>> permute(int[] nums) {

        int n = nums.length;

        List<List<Integer>> result = new ArrayList<>();

        findAllPermutations(0, nums, result, n);

        return result;

    }
}
// vis array apporach

// swap approach
// try out all values in each index
// 1 (2,3) // 1 2 (3) && 1 3 (2)
// 2 (1,3) // 
// 3 (2,3)