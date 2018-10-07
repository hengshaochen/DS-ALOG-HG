
// Author: Huahua
// Runtime: 6 ms
class Solution {
public:
    vector<int> findRedundantDirectedConnection(vector<vector<int>>& edges) {
        
        vector<int> parents(edges.size() + 1, 0);
        vector<int> roots(edges.size() + 1, 0);       
        vector<int> sizes(edges.size() + 1, 1);
        
        vector<int> ans1;
        vector<int> ans2;
        
        for(auto& edge: edges) {
            int u = edge[0];
            int v = edge[1];
            
            // A node has two parents
            if (parents[v] > 0) {
                ans1 = {parents[v], v};
                ans2 = edge;
                
                // Delete the later edge
                edge[0] = edge[1] = -1;
            }
            
            parents[v] = u;
        }
        /*cout << ans1[0] << endl;
        cout << ans1[1] << endl;
        cout << ans2[0] << endl;
        cout << ans2[1] << endl;*/
        //cout << ans2[0] + " " + ans2[1];
        for(const auto& edge: edges) {
            //// cout << "cur edge: " << edge[0] << "," << edge[1] << endl;
            int u = edge[0];
            int v = edge[1];
            
            // Invalid edge (we deleted in step 1)
            if (u < 0 || v < 0) continue;
            
            if (!roots[u]) roots[u] = u;
            if (!roots[v]) roots[v] = v;
            int pu = find(u, roots);
            int pv = find(v, roots);
            //// cout << "pu, pv: " << pu << "," << pv << endl;
            // Both u and v are already in the tree
            if (pu == pv)
                // 回傳edge是case1, 回傳ans1是case2.2
                return ans1.empty() ? edge : ans1;
            
            // Unoin, always merge smaller set (pv) to larger set (pu)
            if (sizes[pv] > sizes[pu])
                swap(pu, pv);
            
            roots[pv] = pu;
            sizes[pu] += sizes[pv];
        }
        // case2.1
        return ans2;
    }
    
private:
    int find(int node, vector<int>& roots) {
        while (roots[node] != node) {
            roots[node] = roots[roots[node]];
            node = roots[node];
        }
        return node;
    }
};