class Solution {
    // O(N^2) 窮舉每個pair
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                ans = Math.max(ans, (j - i + 1) * minHeight);
            }
        }
        return ans;
    }
}

class Solution {
    // O(N) 遞增stack 單調棧
    public int largestRectangleArea(int[] h) {
      int n = h.length, i = 0, max = 0;

      Stack<Integer> s = new Stack<>();

      while (i < n) {
        // as long as the current bar is shorter than the last one in the stack
        // we keep popping out the stack and calculate the area based on
        // the popped bar
        while (!s.isEmpty() && h[i] < h[s.peek()]) {
          // tricky part is how to handle the index of the left bound
          max = Math.max(max, h[s.pop()] * (i - (s.isEmpty() ? 0 : s.peek() + 1)));
        }
        // put current bar's index to the stack
        s.push(i++);
      }

      // finally pop out any bar left in the stack and calculate the area based on it
      // 因為要遇到當前cur比peek小才會激發運算，如果是[1,2,3,4]這種就算不了，所以最後要把stack不為空的也做一遍
      while (!s.isEmpty()) {
        max = Math.max(max, h[s.pop()] * (n - (s.isEmpty() ? 0 : s.peek() + 1)));
      }

      return max;
    }
}