class TrappingRainWater {
    private static void nextGreaterLeft(int[] height, int n, int[] left){
        left[0] = 0;
        int maxSoFar = height[0];
        for(int i = 1; i < n; i++){
            left[i] = maxSoFar;
            maxSoFar = Math.max(maxSoFar, height[i]);
        }
    }
    private static void nextGreaterRight(int[] height, int n, int[] right){
        right[n - 1] = 0;
        int maxSoFar = height[n - 1];
        for(int i = n - 2; i >= 0; i--){
            right[i] = maxSoFar;
            maxSoFar = Math.max(maxSoFar, height[i]);
        }
    }
    public static int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        nextGreaterLeft(height, n, left);
        nextGreaterRight(height, n, right);
        int totalArea = 0;
        for(int i = 0; i < n; i++)
        {
            int avail = Math.min(left[i], right[i]) - height[i];
            if(avail > 0) {
                totalArea += avail;
            }
        }
        return totalArea;
    }
}