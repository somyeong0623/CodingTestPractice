package _2022.Aug_week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_13549 {
	static int n,k;
	static int answer;
	static boolean[] visit;
	static int[] dist;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		visit= new boolean[100001];
		dist = new int[100001];
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(n);
		visit[n]=true;
		while(!q.isEmpty()) {
			int cur =q.peek();
			q.remove();
			
			//1. x-1로 이동 
			if(cur-1>=0) {
				if(visit[cur-1]==false) { //처음 방문이면 
					visit[cur-1]=true;
					dist[cur-1]=dist[cur]+1;
					q.add(cur-1);
				}else {//이미 방문 했던 곳이면 
					if(dist[cur-1]>dist[cur]+1) {
						dist[cur-1]=dist[cur]+1;
						q.add(cur-1);
					}
					
				}
			}
			//2. x+1로 이동 
			if( cur+1<=100000) { //2.3. 에서 왜 범위르 100000으로해도 맞는거지? 200000 으로 해야 맞는거 아닌가 ?
				if(visit[cur+1]==false) { //처음 방문이면 
					visit[cur+1]=true;
					dist[cur+1]=dist[cur]+1;
					q.add(cur+1);
				}else { // 이미 방문했던 곳이면 
					if(dist[cur+1]>dist[cur]+1) {
						dist[cur+1]=dist[cur]+1;
						q.add(cur+1);
					}
				}
			}
			
			//3. x*2로 이동
			if(cur*2<=100000) {
				if(visit[cur*2]==false) { //처음 방문이면 
					visit[cur*2]=true;
					dist[cur*2]=dist[cur];
					q.add(cur*2);
				}else {
					if(dist[cur*2]>dist[cur]) {// x*2동은 시간변화 없더라도, 이전방법으로 x*2에 방문하는데 걸렸던 시간이 새로운 방법으로 x*2에 방문하는데 걸리는 시간보다 컸을수 있으므로 이 과정 포함해야 한다.
						dist[cur*2]=dist[cur];
						q.add(cur*2);
					}
				}
			}
		}
		System.out.println(dist[k]);
	}
}
