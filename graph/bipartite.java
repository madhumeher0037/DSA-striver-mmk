// Bipartite means dividing a graph nodes into two subsets A and B ,such that A contains the node with same color and B conatains nodes with
//  the same color.A graph containing the even cycles is bipartite and odd cycles not bipartite.
// BFS SOLUTION
class Solution {
    public boolean isBipartite(int[][] graph) {
        if(graph.length==1) return true;
        int[] color = new int[graph.length];
        Arrays.fill(color,-1);
        for(int j=0;j<graph.length;j++){
            if(color[j]==-1){
                // Apply bfs
                Queue<Integer> q = new LinkedList<Integer>();
                int firstNode=j;
                q.offer(firstNode);
                color[firstNode]=1;
                while(!q.isEmpty()){
                    int ele = q.poll();
                    for(int i=0;i<graph[ele].length;i++){
                        int adjEle = graph[ele][i];
                        if(color[ele]==color[adjEle]) return false;
                        if(color[adjEle]==-1){
                            color[adjEle] = color[ele]==1?0:1;
                            q.offer(adjEle);
                        }
                    }
                }
            }
        }
        
        return true;
    }
}
