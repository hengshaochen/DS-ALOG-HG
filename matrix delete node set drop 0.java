// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        new Main();
    }
    
    public Main() {
        int[][] matrix = {{1, 1, 0, 1, 1},
                          {0, 1, 0, 0, 1},
                          {0, 1, 0, 1, 1}};
        
        delete(matrix, new int[]{0, 1});
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
    void delete(int[][] matrix, int[] del) {
        matrix[del[0]][del[1]] = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 1) {
                q.add(new int[]{0, i});
                matrix[0][i] = -1;
            }
        }
        
        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0 ,-1};
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int[] cur = q.remove();
                for (int j = 0; j < 4; j++) {
                    int[] neighbor = {cur[0] + dx[j], cur[1] + dy[j]};
                    // check 越界
                    if (neighbor[0] < 0 || neighbor[0] >= matrix.length ||
                        neighbor[1] < 0 || neighbor[1] >= matrix[0].length) {
                        continue;
                    }
                    
                    if (matrix[neighbor[0]][neighbor[1]] == 1) {
                        q.add(neighbor);
                        matrix[neighbor[0]][neighbor[1]] = -1;
                    }
                }
            }
        }
        
        // BFS結束後，掃一次2D Matrix, 把-1變為1, 1變為0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 1;
                } else if (matrix[i][j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
        
    }
}