class Solution {
    public String simplifyPath(String path) {
        
        // Just split the string with "/"

        // if empty add the string 

        // else if the curr char is .. , pop the stack 

        // if char is . dont push it 

        Stack<String> stack = new Stack<>();

        String[] components = path.split("/");

        // System.out.println(Arrays.toString(components));

        for(String comp : components)
        {
            if(comp.equals(".."))
            {
                if(stack.isEmpty() == false) stack.pop();
            }
            else if(comp.equals(".")){
                continue;
            }
            else if(comp.length() > 0){
                stack.push(comp);
            }
        }

        System.out.println(stack);

        String[] stringPaths = new String[stack.size()];

        for(int i = stringPaths.length-1; i>=0;i--)
        {
            stringPaths[i] = "/"+stack.pop();
        }

        // System.out.println(Arrays.toString(stringPaths));



        StringBuilder sb = new StringBuilder();

        for(String str : stringPaths){
            sb.append(str);
        }

        if(sb.length()==0) sb.append("/");

        return sb.toString();
    }
}

