class Solution {

    // Level index approach

    public void findPermutation(int currPos, int[] nums, List<List<Integer>> result , int n)
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
            // Prevent duplicate 
            // if same value dont swap

            if(currPos != ind && isDuplicate(currPos,ind,nums)) continue;

            // same swap logic
            swap(ind,currPos, nums);

            findPermutation(currPos+1, nums, result, n);

            swap(ind,currPos, nums);


        }
    }

    // we should not seen that value till now
    public boolean isDuplicate(int currPos, int valueIndex, int[] nums)
    {
        for(int ptr = currPos ; ptr <= valueIndex-1; ptr++)
        {
            if(nums[ptr] == nums[valueIndex]) return true;
        }

        return false;
    }

    public void swap(int ind, int currPos, int[] nums)
    {
        if(ind == currPos) return;

        int temp = nums[ind];
        nums[ind] = nums[currPos];
        nums[currPos] = temp;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;

        List<List<Integer>> result = new ArrayList<>();

        findPermutation(0, nums, result, n);

        return result;
    }
}