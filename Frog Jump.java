class Solution {
    public boolean canCross(int[] stones) {
        if (stones.length == 0) {
            return false;
        }
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (Integer stone : stones) {
            map.put(stone, new HashSet<>());
        }
        map.get(0).add(0);
        
        for (int i = 0; i < stones.length; i++) {
            for (int lastStep : map.get(stones[i])) {
                for (int nextStep = lastStep - 1; nextStep <= lastStep + 1; nextStep++) {
                    if (nextStep > 0 && map.containsKey(stones[i] + nextStep)) {
                        map.get(stones[i] + nextStep).add(nextStep);
                    }
                }
            }
        }
        
        return !map.get(stones[stones.length - 1]).isEmpty();
    }
}