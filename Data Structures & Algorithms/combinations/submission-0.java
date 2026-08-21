class Solution {

    public void findAllCombinations(int ind, int n, int k, List<Integer> list, List<List<Integer>> result)
    {
        if(list.size() == k){
            result.add(new ArrayList<>(list));
            return;
        }

        if(ind > n) return;

        // pick
        list.add(ind);

        findAllCombinations(ind+1,n, k, list,result);

        // not pick

        list.remove(list.size()-1);

        findAllCombinations(ind+1,n, k, list,result);


    }

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();
        

        findAllCombinations(1,n,k, new ArrayList<>(), result);

        return result;
    }
}

// Imp plan 

// Base case 
// if list size is k , or n goes out of bound , return

// each index
// pick go to next 
// else dont pick and go it next

// all numbers from 1 to n 
// pick up all the k size combinations 

// 1,2,3
// 1,2 | 1,3 | 2,3
// Backtracking 
// every element may or may be present in the result
// so pick and not pick
// 1 may or may not
// if we pick 1, we can use 2 , or not 
// we can use 3 , or not 

// but if the list size goes to k , its one of the result
// we wont be picking up number again , so there wont be duplicates 