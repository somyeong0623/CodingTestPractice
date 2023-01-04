package _2022.Aug_week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
static class Point {
	int r;
	int c;

	public Point(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class boj_17836 {
	static int N, M, T;
	static int[][] arr;
	static int[][] dist;
	static boolean[][] visit;
//	static boolean[][] visit2;
	static int answer;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int gram_r, gram_c;
	static boolean findGram = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		dist = new int[N][M];
		visit = new boolean[N][M];
//		visit2 = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		dist[0][0] = 0;
		bfs1(0, 0);

		for(int i=0; i<N; i++) {
			for(int j=0;j<M; j++) {
				System.out.print(dist[i][j]+" ");
			}
			System.out.println();
		}

		if (findGram && dist[N - 1][M - 1] <= T) { // gram을 찾았고,gram없이도 시간안에 공주한테 도착할 수 있는경우 -> 최솟값 비교
			answer = Math.min(dist[gram_r][gram_c] + (N - 1 - gram_r) + (M - 1 - gram_c), dist[N - 1][M - 1]);
		} else if (findGram && dist[N - 1][M - 1] >T) { // gram을 찾았지만 gram없이는 공주한테 못가는 경우
			if (dist[gram_r][gram_c] + (N - 1 - gram_r) + (M - 1 - gram_c) <= T)
				answer = dist[gram_r][gram_c] + (N - 1 - gram_r) + (M - 1 - gram_c);
			else {
				System.out.println("Fail");
				return;
			}
		} else if (findGram == false && dist[N - 1][M - 1] > T) { // 그람을 못찾았고 그람없이는 공주에게 못가는 경우
			System.out.println("Fail");
			return;
		} else if (findGram == false && dist[N - 1][M - 1] <= T) { // 그람을 못찾았지만 그람없이 공주한테 시간안에 갈수 있는경우
			answer = dist[N - 1][M - 1];
		}
		System.out.println(answer);

	}

	private static void bfs1(int r, int c) {
		Queue<Point> q = new ArrayDeque<Point>();
		visit[r][c] = true;// 첫지점 방문체크
		q.add(new Point(r, c));

		while (!q.isEmpty()) {
			Point cur = q.poll();
			int cur_r = cur.r;
			int cur_c = cur.c;
			for (int d = 0; d < 4; d++) {
				int nr = cur_r + dr[d];
				int nc = cur_c + dc[d];

				if (nr >= 0 && nc >= 0 && nr < N && nc < M && arr[nr][nc] != 1 && visit[nr][nc] == false) {
					dist[nr][nc] = dist[cur_r][cur_c] + 1;
					visit[nr][nc] = true;
					q.add(new Point(nr, nc));
					if (arr[nr][nc] == 2) {
						gram_r = nr;
						gram_c = nc;
						if (dist[gram_r][gram_c] <= T) // Gram을찾은게 의미가 있을때만 (시간안에 찾았을때만) True
							findGram = true;
					}
				}
			}

		}
	}

//	private static void bfs2(int r, int c) {
//		Queue<Point> q2 = new ArrayDeque<Point>();
//		visit2[r][c] = true;
//		q2.add(new Point(r, c));
//
//		while (!q2.isEmpty()) {
//			Point cur = q2.poll();
//			int cur_r = cur.r;
//			int cur_c = cur.c;
//
//			for (int d = 0; d < 4; d++) {
//				int nr = cur_r + dr[d];
//				int nc = cur_c + dc[d];
//
//				if (nr >= 0 && nc >= 0 && nr < N && nc < M && visit2[nr][nc] == false) {
//					if (dist[nr][nc] == 0 || dist[nr][nc] > dist[cur_r][cur_c] + 1) {
//						dist[nr][nc] = dist[cur_r][cur_c] + 1;
//					}
//					
//					q2.add(new Point(nr, nc));
//					visit2[nr][nc] = true;
//				}
//			}
//		}
//	}
}
