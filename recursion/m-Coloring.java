// { Driver Code Starts
    import java.util.*;
    import java.lang.*;
    import java.io.*;
    
    class m-Coloring {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int tc = scan.nextInt();
    
            while (tc-- > 0) {
                int V = scan.nextInt();
                int C = scan.nextInt();
                int E = scan.nextInt();
    
                List<Integer>[] G = new ArrayList[V];
                for (int i = 0; i < V; i++) {
                    G[i] = new ArrayList<>();
                }
    
                for (int i = 0; i < E; i++) {
                    int u = scan.nextInt() - 1;
                    int v = scan.nextInt() - 1;
                    G[u].add(v);
                    G[v].add(u);
                }
                int[] color = new int[V];
    
                System.out.println(new solve().graphColoring(G, color, 0, C) ? 1 : 0);
            }
        }
    }
    // } Driver Code Ends
    
    
    class solve 
    {
        public static boolean checkValid(int[][] g,int[] color,int col,int V){
            for(int i=0;i<g[0].length;i++){
                if(g[V][i]==1 && color[i]==col) return false;
            }
            return true;
        }
        public static  boolean checkGraphColoring(int[][] g,int[] color,int V,int m){
            if(V==g.length) return true;
            
            for(int i=1;i<=m;i++){
                if(checkValid(g,color,i,V)){
                    color[V]=i;
                    if(checkGraphColoring(g,color,V+1,m)) return true;
                    color[V]=0;
                }
            }
            return false;
        }
        //Function to determine if graph can be coloured with at most M colours such
        //that no two adjacent vertices of graph are coloured with same colour.
        public static boolean graphColoring(List<Integer>[] G, int[] color, int i, int m) 
        {
            // Your code here
            int row = color.length;
            int col = color.length;
            int[][] graph = new int[row][col];
            // System.out.println(Arrays.toString(G));
            for(int k=0;k<G.length;k++){
                for(int j=0;j<G[k].size();j++){
                    int c = G[k].get(j);
                    graph[k][c]=1;
                }
            }
            // for(int k=0;k<row;k++) {
            //     for(int j=0;j<col;j++) System.out.print(graph[k][j]+" ");
            //     System.out.println();
            // }
            
            return checkGraphColoring(graph,color,i,m);
        }
    }