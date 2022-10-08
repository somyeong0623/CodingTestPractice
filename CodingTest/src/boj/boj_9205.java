package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

// 9205. 맥주 마시면서 걸어가기 	
public class boj_9205 {

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int TC, N;
	static boolean visited[];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static String answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(br.readLine());
			ArrayList<Point> stores = new ArrayList<Point>();
			Queue<Point> q = new ArrayDeque<Point>();
			visited = new boolean[N];
			answer = "sad";

			st = new StringTokenizer(br.readLine());
			int startC = Integer.parseInt(st.nextToken());
			int startR = Integer.parseInt(st.nextToken());
			// 집 좌표 q에 넣기
			q.add(new Point(startR, startC));

			// 편의점 좌표 리스트에 넣기
			for (int i = 0; i < N; i++) {

				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				stores.add(new Point(r, c));
			}
			st = new StringTokenizer(br.readLine());
			int endC = Integer.parseInt(st.nextToken());
			int endR = Integer.parseInt(st.nextToken());

			// bfs
			while (!q.isEmpty()) {
				Point cur = q.poll();
				
				// 현재 지점 (집 or 편의점) 에서 도착지점까지 갈수있으면 answer 설정 후 break 
				if (Math.abs(cur.r - endR) + Math.abs(cur.c - endC) <= 1000) {
					answer = "happy";
					break;
				}
				
				for (int i = 0; i < stores.size(); i++) {
					Point next = stores.get(i);
					
					//이미 방문한 편의점이면 패스 
					if(visited[i]) continue;
					
					//다음 편의점이  현재 지점(집 or 편의점)에서 갈수 있는 거리이면 방문체크하고 queue에 담기 
					if(Math.abs(cur.r-next.r)+Math.abs(cur.c-next.c)<=1000) {
						visited[i]=true;
						q.add(new Point(next.r, next.c));
					}
				}

			}
			System.out.println(answer);

		}
	}

}
