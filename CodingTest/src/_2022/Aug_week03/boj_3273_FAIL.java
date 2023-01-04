package _2022.Aug_week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//3273. 두 수의 합 
/*
 * 수열 크기 1<=n<=100,000
 * 수열의 정수 1<= ai <=1,000,0000
*  1<= x <= 2,000,000
 */
public class boj_3273_FAIL {

	static int N, X;
	static int[] arr;
	static int answer;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		X = Integer.parseInt(br.readLine());

		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				if(arr[i]+arr[j]==X) {
					answer++;
				}
			}
		}
		
		
		System.out.println(answer);
	}
}
