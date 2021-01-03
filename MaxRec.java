package stack;
// Max Rectangle - Histogram binary matrix


import java.util.Stack;

public class MaxRec {
    public static void main(String[] args) {
        int n = 4, m = 4;
        int M[][] = {{0, 1, 1, 0},
            {1, 1, 1 ,1},
            {1, 1 ,1, 1},
            {1, 1, 0 ,0}};
        int row[] = new int[m];
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(M[i][j] == 0)
                    row[j] = 0;
                else
                    row[j] += 1;
            }
            maxArea = Math.max(maxArea, getHistArea(row, m));
        }
        System.out.println(maxArea);

    }

    private static int getHistArea(int[] row, int m) {

        int lb[] = nsl(row, m);
        int rb[] = nsr(row, m);
        int width = 0, area = 0;

        for (int i = 0; i < m; i++) {
            width = rb[i] - lb[i] - 1;
            area = Math.max(area,  width * row[i]);
        }
//        System.out.println("Area = " +area);
        return area;
    }

    private static int[] nsr(int[] row, int m) {
        Stack<Integer> stack = new Stack<>();
        int res[] = new int[m];
        res[m-1] = m;
        stack.push(m-1);

        for (int i = m-2; i <= 0; i--) {
            while(!stack.isEmpty() && row[i] <= row[stack.peek()]){
                stack.pop();
            }
            res[i] = stack.isEmpty() ? m : stack.peek();

            stack.push(i);
        }

        return res;
    }

    private static int[] nsl(int[] row, int m) {
        Stack<Integer> stack = new Stack<>();
        int res[] = new int[m];
        res[0] = -1;
        stack.push(0);

        for (int i = 1; i < m; i++) {
            while(!stack.isEmpty() && row[i] <= row[stack.peek()]){
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(i);
        }

        return res;
    }
}
