class Solution {
    public void bfsTraversal(int source, boolean[] vis, int[][] adjMat )
    {
        Queue<Integer> q = new LinkedList<>();

        q.add(source);
        vis[source] = true;

        while(!q.isEmpty())
        {
            int node = q.poll();

            for(int it = 0; it < adjMat[node].length; it++)
            {
                if(adjMat[node][it] == 0) continue;

                if(vis[it] == true) continue;

                vis[it] = true;
                q.add(it);
            }
        }
    }
    public int countComponents(int n, int[][] edges) {

        int[][] adjMat = new int[n][n];

        for(int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];
            adjMat[u][v] = 1;
            adjMat[v][u] = 1;
        }

        boolean[] vis = new boolean[n];

        int comp = 0;

        for(int i = 0; i < n; i++)
        {
            if(vis[i] == false)
            {
                bfsTraversal(i,vis,adjMat);
                comp++;
            }
        }

        return comp;
    }
}
