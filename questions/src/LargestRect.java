import java.util.Stack;

class LargestRect {
    public static void computeLeftMinimumArray(int[] heights, int n, int[] arr){
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i ++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i])
            {
                st.pop();
            }
            if(st.isEmpty()){
                arr[i] = 0;
            } else {
                arr[i] = st.peek() + 1;
            }
            st.push(i);
        }
    }
    public static void computeRightMinimumArray(int[] heights, int n, int[] arr){
        Stack<Integer> st = new Stack<>();
        for(int i = n - 1; i >= 0; i --){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i])
            {
                st.pop();
            }
            if(st.isEmpty()){
                arr[i] = n - 1;
            } else {
                arr[i] = st.peek() - 1;
            }
            st.push(i);
        }
    }
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int [] left = new int[n];
        int [] right = new int[n];
        computeLeftMinimumArray(heights, n, left);
        computeRightMinimumArray(heights, n, right);
        int maxArea = 0;
        for(int i = 0; i < n; i++){
            maxArea = Math.max(((right[i] - left[i] + 1) * heights[i]), maxArea);
        }
        return maxArea;
    }
}