class Solution {

    public void findSubSets(int currPos, int[] nums , List<Integer> list, List<List<Integer>> result, int n)
    {
        result.add(new ArrayList<>(list));

        for(int ind = currPos; ind < n; ind++)
        {
            // if currPos or not taken till now is valid , else not valid 
            if(ind == currPos || nums[ind-1] != nums[ind])
            {
                list.add(nums[ind]);
                findSubSets(ind+1, nums, list,result,n);
                list.remove(list.size()-1);

            }
        }

        return;
    }

    public boolean isNotDuplicate(int[] nums , int currPos, int ind)
    {
        // from currPos , to the before of index we should not seen the num
        for(int i = currPos ; i < ind ; i++)
        {
            if(nums[currPos] == nums[ind]) return false;
        }

        return true;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        int n = nums.length;

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        // findSubSets(0,nums, new ArrayList<>(),result, n);

        findSubSets2(0,nums, new ArrayList<>(),result, n);

        return result;
    }

    // pick not pick type
    public void findSubSets2(int ind , int[] nums , List<Integer> list, List<List<Integer>> result, int n)
    {
        // Base case 
        if(ind == n){
            result.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[ind]);
        findSubSets(ind + 1, nums, list, result ,n);

        int nextPickIndex = ind+1;
        while(nextPickIndex < n && nums[nextPickIndex] == nums[ind]){
            nextPickIndex++;
        }

        list.remove(list.size()-1);

        findSubSets(nextPickIndex, nums, list, result ,n);

    }
}
// At every level of list size , try new elements 
// if we are chaning list size 1 to 2
// for the 2nd index try only new elements