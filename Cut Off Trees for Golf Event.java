class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        // 1. put elemet in TreeMap if not 1 or 0
        TreeMap<Integer, int[]> map = new TreeMap<>();
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(0).size(); j++) {
                int cur = forest.get(i).get(j);
                if (cur != 0 && cur != 1) {
                    map.put(cur, new int[]{i, j});
                }
            }
        }
        
        // 2. Travrse the TreeMap caculate the min distance
        int[] cur = {0, 0};
        int ans = 0;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            List<List<Integer>> buf = new ArrayList<>();
            // deep copy
            for (int i = 0; i < forest.size(); i++) {
                buf.add(new ArrayList<>());
                for (int j = 0; j < forest.get(0).size(); j++) {
                    buf.get(i).add(forest.get(i).get(j));
                }
            }
            if (cur[0] == entry.getValue()[0] && cur[1] == entry.getValue()[1]) {
                // 避免開始起點cur={0,0}, 一開始的下個點也是{0,0}
                continue;
            }
            
            int distance = BFS(cur, entry.getValue(), buf);
            if (distance != -1) {
                ans += distance;
            } else {
                return -1;
            }
            cur = entry.getValue();
        }
        return ans;
    }
    
    int BFS(int[] start, int[] end, List<List<Integer>> forest) {
        Queue<int[]> q = new LinkedList<>();
        int ans = 1;
        q.add(start);
        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};
        
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int[] cur = q.remove();
                for (int j = 0; j < 4; j++) {
                    int[] neighbor = new int[]{cur[0] + dx[j], cur[1] + dy[j]};
                    if (outOfBoundary(neighbor, forest)) {
                        continue;
                    }
                    int neighborValue = forest.get(neighbor[0]).get(neighbor[1]);
                    if (neighborValue == 0) {
                        continue;  // 走訪過了
                    }
                    if (neighbor[0] == end[0] && neighbor[1] == end[1]) {
                        return ans;
                    }
                    q.add(neighbor);
                    forest.get(neighbor[0]).set(neighbor[1], 0);
                    
                }
            }
            ans += 1;
        }
        return -1;
    }
    
    private boolean outOfBoundary(int[] neighbor, List<List<Integer>> forest) {
        return neighbor[0] < 0 || neighbor[0] >= forest.size() || neighbor[1] < 0 || neighbor[1] >= forest.get(0).size();
    }
}