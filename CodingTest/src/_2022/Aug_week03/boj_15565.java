package _2022.Aug_week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//15565. 귀여운 라이언 
/*
 * 1: 라이언, 2: 어피치
 * 1<=K<=N<= 1,000,000
 * 
 */
public class boj_15565 {
	static int N, K;
	static int[] arr;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int start = 0;
		int end = 0;
		int cnt = 0;
		if (arr[start] == 1)
			cnt = 1;
		else
			cnt = 0;
		while (start <= end) {
			if (cnt >= K) {
				if (end - start + 1 < answer)
					answer = end - start + 1;
				if (arr[start] == 1)
					cnt--;

				start++;
			} else {
				if (end == N - 1)
					break;
				end++;
				if (arr[end] == 1)
					cnt++;
			}
		}
		if (answer == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(answer);
	}
}
