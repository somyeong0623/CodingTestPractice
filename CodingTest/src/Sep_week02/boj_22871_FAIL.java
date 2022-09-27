package Sep_week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//22971. 징검다리 건너기(large) - 이거 도저히 이해안돼서 일단 건너
public class boj_22871_FAIL {
	static int n;
	static int arr[];
	static long dist[];
	static long answer = Long.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		dist = new long[n]; //dp 배열 
		

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); //A값 
		}
		
		for (int i = 0; i < n-1; i++) { //i -> j로 갈때 필요한 힘 update (max값으로) 
			for (int j = i+1; j < n; j++) {
				dist[j] = Math.max(dist[i], (j- i) * (1 + Math.abs(arr[j] - arr[i])));
			}
			
			for(int x=0; x<n; x++) {
				System.out.print(dist[x]);
			}
			System.out.println();
			
			answer = Math.min(answer, dist[n - 1]); //dist[n-1]의 최솟값 구해야하니까 
			//dist배열 초기화  
			dist[n-1]=0;
			

		}
		
		System.out.println("===last===");
		for(int i=0; i<n; i++) {
			System.out.print(dist[i]);
		}

		System.out.println(answer);
	}
}
