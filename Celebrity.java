package stack;

import java.util.Stack;

public class Celebrity {

    private static int celebrity(int M[][], int n){
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++){
            stack.push(i);
        }

        while(stack.size() >= 2){
            int i = stack.pop();
            int j = stack.pop();

            if(M[i][j] == 1)
                stack.push(j);
            else
                stack.push(i);
        }
        int pot = stack.pop();

        for(int i=0; i<n; i++){
            if(i == pot)
                continue;

            if(M[i][pot] == 0 || M[pot][i] == 1)
                return -1;
        }
        return pot;

    }

    public static void main(String[] args) {
        int N = 3;
        int M[][] = {{0, 1, 0},
            {0, 0, 0},
            {0, 1, 0}};
        int celeb = celebrity(M, N);
        System.out.println(celeb + " is a celebrity.");
    }
}
