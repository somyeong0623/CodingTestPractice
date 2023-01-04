package _2022.Aug_week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//1548. 부분 삼각 수열 
public class boj_1548 {
	static int n;
	static int answer;
	static int arr[];
	static int numbers[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		numbers=new int[3];

		// 예제1번이 이해가 안가서 구글링해보니까 주어진수열의길이가 3이상이면 삼각 수열의 길이는 최소 2부터 시작한다고 한다.
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		if (n == 1 || n == 2) {
			System.out.println(n);
			return;
		}

		answer = 2;
		comb(0,0); //cnt, start
		System.out.println(answer);
	}
	static void comb(int cnt, int start) {
		if(cnt==3) {
			if(solution(numbers))
				answer++;
			return; 
		}
		for(int i=start; i<n; i++) {
			numbers[cnt]=arr[i];
			comb(cnt+1, i+1);
		}
		
	}
	static boolean solution(int[] numbers) {
		Arrays.sort(numbers);
		if(numbers[0]+numbers[1]>numbers[2])
			return true;
		else
			return false;
	}
}
