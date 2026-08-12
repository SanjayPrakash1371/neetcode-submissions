class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack<>();

        for(String token : tokens)
        {
            
            char ch = token.charAt(0);
            if(token.length() == 1 && (ch < '0' ||  ch > '9'))
            {
                int num2 = stack.pop();
                int num1 = stack.pop();

                int value = evaluate(num1,num2, token);
                stack.push(value);
            }
            else{
                int num = Integer.parseInt(token);
                stack.push(num);
                
            }
        }

        return stack.pop();
    }

    public int evaluate(int num1, int num2, String expression)
    {
        switch(expression)
        {
            case "+":
                return num1 + num2;

            case "-":
                return num1 - num2;

            case "*":
                return num1 * num2;

            case "/":
                return num1 / num2;
            


        }
        return 0;
    }
}
// if its a number add it into the stack , if its a expressing , take the last two numbers and do the operation and push it back to the stack. 

