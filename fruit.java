class Solution {
    public int totalFruit(int[] tree) {
        // Brute Force: try every start point for the input array -> Time: O(N^2) Space: O(1)
        // Better Solution: Use the sliding window algorithm, maintain a interval that only contains 2 different fruit -> 
        // Time: O(N) Space : O(size of HashMap)
        Map<Integer, Integer> fruitType = new HashMap<>();
        int ans = 0;
        int start = 0, end = 0;
        while (end < tree.length) {
            fruitType.put(tree[end], fruitType.getOrDefault(tree[end], 0) + 1);
            if (fruitType.size() > 2) {
                // try to delete fruit from the current start point until satisfy the condition (fruit type <= 2)
                fruitType.put(tree[start], fruitType.get(tree[start]) -1);
                if (fruitType.get(tree[start]) == 0) {
                    fruitType.remove(tree[start]);
                } 
                start++;
            }
            
            ans = Math.max(ans, end - start + 1);
            end++;
        }
        return ans;
    }
}