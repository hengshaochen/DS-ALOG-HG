// "static void main" must be defined in a public class.
public class Main {
    // 牛排館
    public static void main(String[] args) {
        new Main();
    }
    public Main() {
        List<List<Integer>> dist = new ArrayList<>();
        List<Integer> p1 = new ArrayList<>();
        List<Integer> p2 = new ArrayList<>();
        List<Integer> p3 = new ArrayList<>();
        List<Integer> p4 = new ArrayList<>();
        p1.add(1);
        p1.add(2);
        p2.add(3);
        p2.add(4);
        p3.add(1);
        p3.add(-1);
        p4.add(100);
        p4.add(-100);
        
        dist.add(p1);
        dist.add(p2);
        dist.add(p3);
        dist.add(p4);
        
        System.out.println(findKNearest(2, dist));
    }

    List<List<Integer>> nearestRestaurant(List<List<Integer>> dist, int k) {
        if (dist == null || dist.size() == 0 || dist.size() < k) {
            return new ArrayList<>();
        }

        // Traverse Map, and build Priority Queue(Min heap)
        Comparator<List<Integer>> cmp = new Comparator<List<Integer>>() {
            public int compare(List<Integer> e1, List<Integer> e2) {
                double dis2 = Math.pow((double)e2.get(0), 2) + Math.pow((double)e2.get(1), 2);
                double dis1 = Math.pow((double)e1.get(0), 2) + Math.pow((double)e1.get(1), 2);
                if (dis1 > dis2) {
                    return -1;
                } else if (dis1 == dis2){
                    return 0;
                } else {
                    return 1;
                }
            }
        };
        
        PriorityQueue<List<Integer>> pq = new PriorityQueue<List<Integer>>(k, cmp);
        
        //for (List<Integer> cur : List<List<Integer>> dist) {
        for (int i = 0; i < dist.size(); i++) {
            List<Integer> cur = dist.get(i);
            if (pq.size() < k) {
                pq.add(cur);
            } else {
                if (cmp.compare(pq.peek(), cur) == -1) {
                    pq.remove();
                    pq.add(cur);
                }
            }
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(pq.remove());
        }
        return ans;
    }
}


// maze shortest path
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        new Main();
    }
    
    public Main() {
        int[][] matrix = {{0, 1, 1},
                          {0, 1, 1},
                          {0, 9, 0}};
        
        System.out.println(shortest(matrix));
    }
    
    int shortest(int[][] m) {
        int row = m.length;
        int col = m[0].length;
        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        int step = 1;
        
        while (!q.isEmpty()) {
            int qsize = q.size();
            /*if (m[cur[0]][cur[1]] == 9) {
                return step;
            }*/
            step++;
            for (int i = 0; i < qsize; i++) {
                int[] cur = q.remove();
                for (int j = 0; j < 4; j++) {
                    int[] neighbor = new int[]{cur[0] + dx[j], cur[1] + dy[j]};
                    if (outOfBoundary(m, neighbor[0], neighbor[1])) {
                        continue;
                    }
                    if (m[neighbor[0]][neighbor[1]] == 0) {
                        continue;
                    }
                    
                    // System.out.println(neighbor[0] + "," + neighbor[1] + " "+ step);
                    if (m[neighbor[0]][neighbor[1]] == 9) {
                        return step;
                    }
                    if (m[neighbor[0]][neighbor[1]] == 1) {
                        q.add(neighbor);
                        m[neighbor[0]][neighbor[1]] = 0;
                    }
                }
            }
            System.out.println("----");
        }
        
        return -1;
    }
    
    private boolean outOfBoundary(int[][] grid, int i, int j) {
        return j < 0 || j >= grid[0].length || i < 0 || i >= grid.length;
    }
}