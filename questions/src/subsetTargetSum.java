public class subsetTargetSum {

    public int subsetsToReachTarget(int[] nums, int target) {
        int n = nums.length;
        int ways[] = new int[target + 1];
        ways[0] = 1;
        for (int x : nums) {
            for(int j = target; j >= x; j--){
                ways[j] += ways[j - x];
            }

    }
    return ways[target];
    }
}
