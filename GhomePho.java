class Solution {
    public boolean exist(char[][] board, String target_word) {
        if (board == null || board.length == 0) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                for (int dir = 0; dir < 8; dir++) { 
                    if (dfs(i, j, board, target_word, dir, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    
    boolean dfs(int i, int j, char[][] grid, String target_word, int dir, int curLength) {
        // base case
        if (outBoundary(i, j, grid) || target_word.charAt(curLength) != grid[i][j]) {
            return false;
        }

        if (curLength == target_word.length() -1) {
            return true;
        }

        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0,  1, -1, 1, -1, 0, 1};

        if (dfs(i + dx[dir], j + dy[dir], grid, target_word, dir, curLength + 1))   {
            return true;
        }
        return false;
    }

    boolean outBoundary(int x, int y, char[][] grid) {
        return x < 0 || x >= grid.length || y < 0 || y >= grid[0].length;
    }

}