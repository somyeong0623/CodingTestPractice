import java.util.*;

public class 가장먼노드{
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        int dist[]= new int[n+1];
        ArrayList<Integer>[] edges = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            edges[i]=new ArrayList<Integer>();
        }
        for(int i=0; i<edge.length; i++){
            int from=edge[i][0]; 
            int to=edge[i][1];
            edges[from].add(to);
            edges[to].add(from);
        }
        // for(int i=1; i<=n; i++){
        //     for(int j=0; j<edges[i].size(); j++){
        //         System.out.print(edges[i].get(j)+" ");
        //     }
        //     System.out.println();
        // }
        boolean visit[] = new boolean[n+1];
        Queue<Integer> q = new ArrayDeque<Integer>();
        q.add(1);
        visit[1]=true;
        while(!q.isEmpty()){
            int cur= q.poll();
            for(int i=0; i<edges[cur].size(); i++){
                int next=edges[cur].get(i);
                if(visit[next]==false){
                    visit[next]=true;
                    dist[next]=dist[cur]+1;
                    q.add(next);
                }
            }
        }
        int max=0;
        for(int i=1; i<=n; i++){
            max=Math.max(max,dist[i]);
            System.out.println("dist: "+dist[i]);
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=1; i<=n; i++){
            if(dist[i]==max)
                list.add(i);
        }
            

        
        return list.size();
    }
}

