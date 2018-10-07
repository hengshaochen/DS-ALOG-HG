// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        new Main();
    }
    
    public Main() {
        int[][] grid = {{1, 0, 0, 0},
                        {0, 0, 1, 1},
                        {0, 0, 1, 1}};
        System.out.println(find(grid));
    }
    
    int rst=0;
    public int find(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0){
                    dfs(grid,0,i,j,2);
                    dfs(grid,0,i,j,4);
                    dfs(grid,0,i,j,8);
                    dfs(grid,0,i,j,16);
                }
            }
        }
        return rst;
    }
    public void dfs(int[][] grid, int count, int i,int j,int dir){
        int m=grid.length;
        int n=grid[0].length;
        if(count==2) rst++;
        if(i<0||i==m||j<0||j==n||(grid[i][j]&dir)!=0||grid[i][j]==0) return;
        grid[i][j]=(grid[i][j]|dir);
        if(dir==2) dfs(grid,count+1,i+1,j,2);
        else if(dir==4) dfs(grid,count+1,i,j+1,4);
        else if(dir==8) dfs(grid,count+1,i+1,j+1,8);
        else if(dir==16) dfs(grid,count+1,i+1,j-1,16);
    }

}