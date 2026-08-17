import java.util.Arrays;
import java.util.Stack;

class MaximalRectangle {
    private void leftBoundary(int[] heights, int n, int[] left){
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i ++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.isEmpty())
                left[i] = 0;
            else
                left[i] = st.peek() + 1;
            st.push(i);
        }
    }
    private void rightBoundary(int [] heights, int n, int[] right){
        Stack<Integer> st = new Stack<>();
        for(int i = n - 1; i >= 0; i --){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.isEmpty())
                right[i] = n - 1;
            else
                right[i] = st.peek() - 1;
            st.push(i);
        }
    }
    private int findMaxRectPerRow(int[] heights, int n){
        int maxArea = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        leftBoundary(heights, n, left);
        rightBoundary(heights, n, right);
        for(int i = 0; i < n; i++){
            maxArea = Math.max(maxArea, ((right[i] - left[i]) + 1) * heights[i]);
        }
        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] heights = new int[n];
        int maxArea = 0;
        Arrays.fill(heights, 0);
        for (char[] chars : matrix) {
            for (int j = 0; j < n; j++) {
                if (chars[j] == '1') {
                    heights[j]++;
                } else
                    heights[j] = 0;
            }
            int area = findMaxRectPerRow(heights, n);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}