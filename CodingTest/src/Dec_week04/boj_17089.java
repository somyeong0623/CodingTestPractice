package Dec_week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//17089. 세 친
public class boj_17089 {
	static class Info{
		int x;
		int y;
		public Info(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	
	static int N,M;
	static Set<Integer> set[];
	static ArrayList<Info> infos;
	static int answer=Integer.MAX_VALUE;
	static int numbers[];
	static int totalCnt;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		numbers=new int[3];
		set = new HashSet[N+1];
		infos= new ArrayList<Info>();
		
		
		// list배열 초기화
		for(int i=0; i<=N; i++) {
			set[i]=new HashSet<Integer>();
		}
		
		for(int i=0 ;i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x= Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			set[x].add(y);
			set[y].add(x);
			infos.add(new Info(x, y));
			
		}
		
		for(int i=0; i<infos.size();i ++) {
			Info cur = infos.get(i);
			for(int j=1; j<=N; j++) {
				if(j==cur.x || j==cur.y)
					continue;
				
				if(isFriend(cur.x, cur.y, j)) {
					answer=Math.min(answer, set[cur.x].size()+set[cur.y].size()+set[j].size()-6);
				}
			}
		}
	
		if(answer==Integer.MAX_VALUE)
			answer=-1;
		
		System.out.println(answer);
		
	}

	
	public static boolean isFriend(int x, int y, int j) {
		if(set[x].contains(j) && set[y].contains(j))
			return true;
		else
			return false;
			
	}

}
