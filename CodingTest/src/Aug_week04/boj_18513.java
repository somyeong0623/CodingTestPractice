package Aug_week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

//18513. 샘터 (시간초과)
public class boj_18513 {
	static int N, K;
	static boolean[] arr = new boolean[200300000];
	static int cnt;
	static long answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(st.nextToken());
			list.add(x + 100000000);
			arr[x + 100000000] = true; // 샘터 true로 체크
		}
		int index=1;
		loop: while (true) {
			for (int i = 0; i < N; i++) {
				if (arr[list.get(i) - index] == false) {
					arr[list.get(i) - index] = true;
					cnt++;
					answer += index;
				}
				if (cnt == K)
					break loop;

				if (arr[list.get(i) + index] == false) {
					arr[list.get(i) + index] = true;
					cnt++;
					answer += index;
				}
				if (cnt == K)
					break loop;
			}
			index++;
		}
		System.out.println(answer);
	}
}
