// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 7, 8, 9, 10, 2};
        int left = 0, right = 1;
        int ans = 0;
        if (nums.length == 1) {
            System.out.println("1");
        }
        
        while (right < nums.length) {
            if (nums[right] == nums[right - 1] + 1) {
                ans = Math.max(ans, right - left + 1);
            } else {
                left = right;
            }
            right++;
        }
        System.out.println(ans);
    }
}