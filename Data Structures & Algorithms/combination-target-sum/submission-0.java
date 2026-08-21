class Solution {

    public void findCominationSums(int ind, int target ,int[] nums,  List<Integer> list , List<List<Integer>> result , int n)
    {
        // Base case 

        if(target == 0){
            result.add(new ArrayList<>(list));
            return;
        }

        if(ind == n) return;



        // pick
        // if pick stay at same index
        if(nums[ind] <= target){
            list.add(nums[ind]);
            findCominationSums(ind, target - nums[ind],nums, list, result,n);
            list.remove(list.size()-1);
        }

        // not pick
        // go to next index 
        findCominationSums(ind+1, target,nums, list, result,n);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {

        int n = nums.length;
        
        List<List<Integer>> result = new ArrayList<>();

        findCominationSums(0,target,nums, new ArrayList<>(),result , n);

        return result;
    }
}

// Imp plan
// every elements may or may not be in the list
// so we need to try by picking , and also try without picking
// also if picking up the element increases the target , no use of picking it
// Also we can pick the number any number of times 
// we pick up 2 and again we can pick 2 
// but if we dont need 2 , move to 3



// This is very much similar to combinations
// but we need only subsets with sum eq to target
// it contains of unique intergers 
// so we wont end up picking it again
