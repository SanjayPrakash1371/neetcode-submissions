class Solution {

    public void findPartitions(int currPos , String s, List<String> list, List<List<String>> result, int n)
    {
        // Base case

        if(currPos == n)
        {
            result.add(new ArrayList<>(list));
            return;
        }


        for(int ind = currPos; ind < n; ind++)
        {
            String part = s.substring(currPos, ind+1);

            if(!isPalindrome(part)) continue;

            list.add(part);

            findPartitions(ind+1, s, list,result ,n );

            list.remove(list.size()-1);


        }
    }

    public boolean isPalindrome(String s)
    {
        int left = 0;
        int right = s.length()-1;

        while(left < right)
        {
            if(s.charAt(left) != s.charAt(right)) return false;

            left++;
            right--;
        }

        return true;
    }

    public List<List<String>> partition(String s) {
        
        List<List<String>> result = new ArrayList<>();

        int n = s.length();

        findPartitions(0,s, new ArrayList<>(),result,n);


        return result;



    }
}

// imp plan
// from ind to n , get the substring and check if it palindrome, if yes add to list and do the partition for ind+ 1 to n
// revert back the list and do part for ind+1

// we need to try all the possibilites 
// at every index , do the partition , check if its a plaindrome
// if yes , take into the list , and do the partition for ind+1 to n
// do unitil ind == n

