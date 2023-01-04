package _2022.Sep_week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_10971 {
	static int n;
	static int cnt, sum, last;
	static int answer = Integer.MAX_VALUE;
	static boolean[] visited;
	static ArrayList<Integer> edges[];
	static int[][] dist;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		edges = new ArrayList[n];
		dist = new int[n][n];

		for (int i = 0; i < n; i++) {
			edges[i] = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int x = Integer.parseInt(st.nextToken());
				if (x != 0) {
					edges[i].add(j);
					dist[i][j] = x;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			visited = new boolean[n];
			cnt = 0;
			sum = 0;
			visited[i]=true;
			dfs(i, i, cnt, sum);
		}
		System.out.println(answer);
	}

	public static void dfs(int start, int v, int cnt, int sum) {
		if (cnt == n-1) {
			if (dist[v][start] != 0)
				answer = Math.min(answer, sum+dist[v][start]);
			return;

		}
		int cur = v;
	
		for (int i = 0; i < edges[v].size(); i++) {
			int next = edges[v].get(i);
			if (visited[next] == false) {
				visited[v] = true;
				dfs(start,next, cnt + 1, sum + dist[v][next]);
				visited[next] = false;
			}
		}
	}

}
