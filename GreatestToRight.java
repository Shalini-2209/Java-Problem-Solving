package stack;

import java.util.Stack;

public class GreatestToRight {

    static void findGreatest(long src[]){
        int n = src.length;
        long res[] = new long[n];
        Stack<Long> stack = new Stack<>();

        //-a+
        res[n-1] = -1;
        stack.push( src[n-1]);
        for(int i=n-2; i>=0; i--){
            while(!stack.isEmpty() && src[i] >= stack.peek()){
                stack.pop();
            }
            if(stack.isEmpty())
                res[i] = -1;
            else
                res[i] = stack.peek();
            stack.push(src[i]);
        }

        for(int i=0;i<n; i++){
            System.out.println(res[i]);
        }

    }

    public static void main(String[] args) {
        long arr[] = {22, 20, 1, 90, 99};
        findGreatest(arr);
    }
}
