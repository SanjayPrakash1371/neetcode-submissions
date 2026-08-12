class Solution {
    public int calPoints(String[] operations) {
        
        Stack<Integer> stack = new Stack<>();

        for(String operation : operations)
        {
            if(operation.equals("D"))
            {
                int prev = stack.peek();
                stack.push(prev * 2);
                System.out.println(stack);
            }
            else if(operation.equals("C"))
            {
                int prev = stack.pop();
                System.out.println(stack);
            }
            else if(operation.equals("+"))
            {
                int num2 = stack.pop();
                

                int num3 = stack.peek() + num2;
                stack.push(num2);
                stack.push(num3);

                System.out.println(stack);
            }
            else{
                stack.push(Integer.valueOf(operation));
                System.out.println(stack);
            }
        }

        int sum = 0;

        while(!stack.isEmpty())
        {
            sum+=stack.pop();
        }

        return sum;
    }
}