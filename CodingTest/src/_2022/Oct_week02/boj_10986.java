package _2022.Oct_week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 10986. 나머지 합 
public class boj_10986 {
	static int N, M;
	static int arr[];
	static int remainder[];
	static long answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		remainder = new int[M]; // 주의-> M으로 안하고 N으로 해서 계속 ArrayIndex 런타임에러 떳음.
		int sum = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			sum += num;
			sum%=M; // sum : i번째의 누적합을 M으로 mod취한 값 
			remainder[sum]++; // sum의 값이 0~M-1 것이 각각 몇개인지 저장
		}

		// i번째까지의 누적합을 M으로 모드 취한 결과에서 (remainder)
		// 각 결과마다 2개씩 고를 수 있는 조합의 갯수 구하기
		for (int i = 0; i < M; i++) {
			int size = remainder[i];
			long combi = (long) size * (size - 1) / 2; // nC2 공식에 의해
			answer += combi;
		}
		answer += remainder[0];

		System.out.println(answer);

	}

}
