// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        new Main();
    }
    
    public Main() {
        int[] nums = {1, 3, 4, 5, 9};
        double center = 4.5;
        
        int[] ans = sortByCenter(nums, center);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
    
    int[] sortByCenter(int[] nums, double center) {
        int[] ans = new int[nums.length];
        
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid] < center) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        int l = 0, r = 0;
        if (Math.abs(nums[start] - center) <= Math.abs(nums[end] - center)) {
            // start比較接近
            l = start;
            r = start;
        } else {
            l = end;
            r = end;
        }
        
        int idx = 0;
        ans[idx++] = nums[l];
        l--;
        r++;
        while (l >= 0 && r < nums.length) {
            if (Math.abs(nums[l] - center) <= Math.abs(nums[r] - center)) {
                ans[idx++] = nums[l--];
            } else {
                ans[idx++] = nums[r++];
            }
        }
        
        while (l >= 0) {
            ans[idx++] = nums[l--];
        }
        while (r < nums.length) {
            ans[idx++] = nums[r++];
        }
        
        return ans;
    }
}