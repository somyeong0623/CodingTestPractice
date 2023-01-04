package _2022.Aug_week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

//18513. 샘터 (시간초과)

class Info { //샘터 또는 집의 정보 
	int x; // 위치
	int dist; // 샘터로부터의 거리

	public Info(int x, int dist) {
		this.x = x;
		this.dist = dist;
	}
}

public class boj_18513_queue {
	static int N, K;
	static boolean[] arr = new boolean[300000000];
	static int cnt;
	static long answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		Queue<Info> queue = new ArrayDeque<Info>(); // 샘터 또는 집을 담을 queue 
		HashSet<Integer> visit = new HashSet<Integer>();// 좌표의 방문체크를 위한 HashSet 
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(st.nextToken());
			queue.add(new Info(x+100200000, 0)); // 샘터는 거리가 0짜리
			visit.add(x+100200000);
			arr[x+100200000]=true;

		}

		loop: while (!queue.isEmpty()) {

			Info cur = queue.poll();// queue의 맨앞 빼기 
			// 왼쪽체크
			if (arr[cur.x-1]==false) {
				answer += cur.dist + 1; // 샘터로부터의 거리 더하기 
				queue.add(new Info(cur.x-1,cur.dist+1)); // 지은 집 정보 queue에추가 
//				visit.add(cur.x-1); // 방문한 좌표 hashset에 추가 
				arr[cur.x-1]=true;
				cnt++; // 집 갯수 증가 
			}
			if(cnt==K) // K개의 집을 지었으면 break;
				break loop;

			//오른쪽 체크
			if(arr[cur.x+1]==false) {
				answer+=cur.dist+1;
//				visit.add(cur.x+1);
				arr[cur.x+1]=true;
				queue.add(new Info(cur.x+1, cur.dist+1));
				cnt++; // 집 갯수 증가 
			}
			if(cnt==K)
				break loop;
		}
		System.out.println(answer);
	}
}
