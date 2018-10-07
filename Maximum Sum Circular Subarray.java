class Solution {
    public int maxSubarraySumCircular(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int case1 = maxSubArray(A);
        
        int prefix = 0;
        for (int i = 0; i < A.length; i++) {
            prefix += A[i];
            A[i] = -A[i];
        }
        
        // 這題規定不能什麼都不取
        int case2 = prefix + maxSubArray(A);
        if (case2 == 0) {
            // case2為0時代表什麼都不選，這題不允許，因此把case2的答案設為最小值作廢，選case1
            case2 = Integer.MIN_VALUE;
        }
        
        return Math.max(case1, case2);
    }
    
    public int maxSubArray(int[] nums) {
        // 用一個pre保存累加數值, 用min保存當前最小值
        int min = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            max = Math.max(max, sum - min);
            min = Math.min(min, sum);
        }
        return max;
    }

}