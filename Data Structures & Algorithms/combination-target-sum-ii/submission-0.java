class Solution {

    public void findSubsets(int currPos, int target, int[] candidates, int n, List<Integer> list , List<List<Integer>> result)
    {
        // Base case 


        if(target == 0){

            result.add(new ArrayList<>(list));
            return;
        }

        if(currPos > n) return;


        for(int ind = currPos; ind < n; ind++)
        {
            if( ind!= currPos && candidates[ind] == candidates[ind-1]) continue;
            
            if(candidates[ind] > target) break;

            list.add(candidates[ind]);
            findSubsets(ind+1, target - candidates[ind], candidates, n, list,result);
            list.remove(list.size()-1);
            
        }

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        int n = candidates.length;

        Arrays.sort(candidates);
        
        List<List<Integer>> result = new ArrayList<>();

        findSubsets(0,target, candidates,n, new ArrayList<>(), result);

        return result;

    }
}
