package Aug_week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int r;
	int c;

	public Point(int r, int c) {
		this.r = r;
		this.c = c;
	}

}

//14940. 쉬운 최단거리 
public class boj_14940 {
	static int n, m; // 세로,  가로
	static int[][] arr; //원래배
	static int[][] dist; //거리배열 

	static int r, c;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		dist = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) {
					r = i;
					c = j;
				}
			}
		}
		bfs(r, c);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 1 && dist[i][j] == 0) // 땅인부분중에서 도달할수 없는 위치
					dist[i][j] = -1;

				sb.append(dist[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

	private static void bfs(int r, int c) {
		Queue<Point> q = new ArrayDeque<Point>();
		q.add(new Point(r, c));

		while (!q.isEmpty()) {
			Point cur = q.poll();
			r = cur.r;
			c = cur.c;

			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				//범위체크, 갈수있는 땅인지 체크, 이미 방문한곳인지 체크 
				if (nr >= 0 && nc >= 0 && nr < n && nc < m && arr[nr][nc] == 1 && dist[nr][nc] == 0) {
					dist[nr][nc] = dist[r][c] + 1;
					q.add(new Point(nr, nc));

				}
			}
		}

	}
}
