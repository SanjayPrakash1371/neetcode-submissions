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

        // findSubsets(0,target, candidates,n, new ArrayList<>(), result);

        findCombinations2(0,candidates, target,new ArrayList<>(),result,n);

        return result;

    }
     
    public void findCombinations2(int ind , int[] arr, int target, ArrayList<Integer> list , List<List<Integer>>  result, int n)
    {
        // if target left is 0
        
        if(target == 0){
            result.add(new ArrayList<>(list));
            return;
        }
        
        // no more index to compare 
        if(ind == n) return;
        
        
        // pick
        
        if(arr[ind] <=target){
            list.add(arr[ind]);
            findCombinations2(ind+1, arr, target - arr[ind], list, result,n);
            list.remove(list.size()-1);
        }
        
        // not pick
        // go to the index which is not equal to current index 
        int nextCombIndex = ind+1;
        
        while(nextCombIndex < n && arr[ind] == arr[nextCombIndex]){
            nextCombIndex++;
        }
        
        findCombinations2(nextCombIndex, arr, target, list, result,n);
        
        return;
        
        
        
    }
}
