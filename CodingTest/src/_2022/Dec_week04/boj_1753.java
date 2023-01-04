package _2022.Dec_week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//1753. 최단 경로 
public class boj_1753 {
	static class Info{
		int to; // 경로의 도착지점 번호 
		int w; // 경로의 가중치 
		public Info(int to, int w) {
			this.to=to;
			this.w=w;
		}
	}
	
	static int V,E,K; // 정점 갯수, 간선 갯수, 시작 번호 
	static ArrayList<Info> edges[];
	static int dist[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		
		K=Integer.parseInt(br.readLine());
		dist= new int[V+1];
		
		edges = new ArrayList[V+1];
		for(int i=0; i<=V; i++) {
			edges[i]= new ArrayList<Info>(); // 리스트배열 초기화 
			dist[i]=Integer.MAX_VALUE; // 거리배열 최댓값으로 초기화 
		} 
		
	
		for(int i=0; i<E; i++) {
			int from, to, w;
			st  = new StringTokenizer(br.readLine());
			from= Integer.parseInt(st.nextToken());
			to=Integer.parseInt(st.nextToken());
			w=Integer.parseInt(st.nextToken());	
			
			edges[from].add(new Info(to, w)); // 인접리스트 생성 
		}
		
		dist[K]=0;
		PriorityQueue<Info> queue = new PriorityQueue<Info>((o1,o2)->o1.w-o2.w); // 가중치 기준 오름차순 정렬 
//		Queue<Integer> queue= new ArrayDeque<Integer>();  // 그냥 queue는 시간초과 발생 
		queue.add(new Info(K,0));
		
		while(!queue.isEmpty()) {  // 다익스트라 시작 
			Info cur = queue.poll();

			
			for(int i=0; i<edges[cur.to].size(); i++ ) {
				Info next= edges[cur.to].get(i);
				
				if(dist[next.to]>dist[cur.to]+next.w) {// 다음 정점을 갈 때, 현재 정점을 거쳐서 가는경로가 최단경로일 경우, 거리값 갱신하고 queue에 넣기. 
					dist[next.to]=dist[cur.to]+next.w;
					queue.add(new Info(next.to,dist[next.to]));
				}
			}
		}
		
		for(int i=1; i<=V; i++) {
			if(dist[i]==Integer.MAX_VALUE)
				sb.append("INF").append("\n");
			else
				sb.append(dist[i]).append("\n");
				
		}
		System.out.println(sb);
		
	}

}
