class Solution {

    public void findAllSubsets(int ind, int[] nums , List<Integer> list, List<List<Integer>> result, int n)
    {
        // Base case 
        if(ind == n){
            // no more elements to pick
            result.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[ind]);
        findAllSubsets(ind+1, nums, list, result ,n);
        list.remove(list.size()-1);
        findAllSubsets(ind+1, nums, list, result,  n);

        return;

    }

    public List<List<Integer>> subsets(int[] nums) {

        int n = nums.length;
        
        List<List<Integer>> result = new ArrayList<>();


        findAllSubsets(0,nums, new ArrayList<>(),result ,n);

        return result;

    }
}

// Imp
// carry a list and result list
// pick not pick
// backtracking approach

// Give arr of uniq integers 
// find all subsets 
// but it should not contain duplicates 
// Since it is of uniq intergers we wont be having duplicate subsets

