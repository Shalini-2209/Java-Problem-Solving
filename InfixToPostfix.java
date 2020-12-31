package stack;

import java.util.Stack;

public class InfixToPostfix {

    public static int getPriority(char ch){
        switch (ch){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static void postFix(String s){
        Stack<Character> stack = new Stack<>();
        String result = new String("");

        for(int i=0; i<s.length(); ++i){
            char val = s.charAt((i));
            if(Character.isLetterOrDigit(val)){
                result += val;
            }
            else if(val == '('){
                stack.push(val);
            }
            else if(val == ')'){
                while(!stack.isEmpty() && stack.peek() != '('){
                    result += stack.pop();
                }
                stack.pop();
            }
            //Operator function
            else {
               while(!stack.isEmpty() && getPriority(val) <= getPriority(stack.peek())){
                    result += stack.pop();
                }
                stack.push(val);
            }
        }

        while(!stack.isEmpty()){
            if(stack.peek() == '('){
                System.out.println("Invalid statement");
            }
            result += stack.pop();
        }
        System.out.println(result + "Postfix string");


    }
    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        postFix(exp);
    }
}
