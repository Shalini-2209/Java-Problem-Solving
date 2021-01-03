package stack;

import java.util.Scanner;
import java.util.Stack;

public class MaxArea {
    static long[] findOnLeft(long src[]){
        Stack<Integer> stack = new Stack<>();
        int n = src.length;
        long res[] = new long[n];

        res[0] = -1;
        stack.push(0);

        for(int i=1; i<n; i++){
            //-a+
            while (!stack.isEmpty() && src[i] <= src[stack.peek()]){
                stack.pop();
            }
            res[i] = stack.isEmpty()? -1 : stack.peek();

            stack.push(i);
        }
        for(int i=0;i<n; i++){
            System.out.println(res[i]);
        }

        return res;

    }

    static long[] findOnRight(long hist[], int n){
        Stack<Integer> stack = new Stack<Integer>();
        long rb[] = new long[(int)n];
        rb[(int)n-1] = (int)n;
        stack.push((int)n-1);
        for(int j=(int)n-2; j>=0; j--){
            while(!stack.isEmpty() && hist[j]<=hist[stack.peek()]){
                stack.pop();
            }
            rb[j] = stack.isEmpty()? (int)n : stack.peek();
            stack.push(j);
        }
        for(int i=0;i<n; i++){
            System.out.println("Array"+rb[i]);
        }
        return rb;
    }


    public static void main(String[] args) {

        long arr[] = {5, 4, 3, 2, 1};
        int n = arr.length;
        long lb[] = new long[arr.length];
        long rb[] = new long[arr.length];
        long width;
        long area=0, maxArea=0;

        // Finding smallest on right/left
        lb = findOnLeft(arr);
        rb = findOnRight(arr, (int)arr.length);

        for(int i=0; i<n; i++){
            width = rb[i] - lb[i] - 1;
            area = width * arr[i];
            maxArea = Math.max(area, maxArea);

        }
        System.out.println("Max Rectangular area on a histogram : " + maxArea );
    }
}
