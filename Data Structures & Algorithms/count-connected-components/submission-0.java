class Solution {
    public void bfsTraversal(int source, boolean[] vis, ArrayList<Integer>[] adjList)
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        vis[source] = true;

        while(!q.isEmpty())
        {
            int node = q.poll();

            for(int it : adjList[node])
            {
                if(vis[it]) continue;
                vis[it] = true;
                q.add(it);
            }
        }
    }
    public int countComponents(int n, int[][] edges) {

        // Create adjList

        ArrayList<Integer>[] adjList = new ArrayList[n];

        for(int i = 0; i < n; i++)
        {
            adjList[i] = new ArrayList<>();
        }

        for(int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];

            adjList[u].add(v);
            adjList[v].add(u);
        }

        boolean[] vis = new boolean[n];


        int components = 0;

        for(int i = 0; i < n; i++)
        {
            if(vis[i] == false)
            {
                components++;

                bfsTraversal(i,vis,adjList);
            }
        }

        return components;
    }
}
