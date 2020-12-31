package stack;
import java.util.Stack;

public class SmallestToLeft {
    static void findSmallest(long src[]){
        Stack<Long> stack = new Stack<>();
        int n = src.length;
        long res[] = new long[n];

        res[0] = -1;
        stack.push(src[0]);

        for(int i=1; i<n; i++){
            //-a+

            while (!stack.isEmpty() && src[i] <= stack.peek()){
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
        long arr[] = {2, 20, 1, 90, 99};
        findSmallest(arr);
    }
}
