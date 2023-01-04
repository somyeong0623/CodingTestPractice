package _2022.Sep_week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//14712. 넴모넴모 
//네모가 있는칸을 1이라고 하고 없는 칸을 0이라고 하자 
// N*M 배열의 각 칸이 1인경우와 0인경우 모든경우에 넴모가 존재하는지 확인한다. 

public class boj_14712 {
	static int n, m;
	static int answer;
	static int arr[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		func(0, 0);// r,c (0,0)부터 시작 
		System.out.println(answer);

	}

	public static void func(int r, int c) {  //재귀 함수 

		if (r == n - 1 && c == m - 1) { // 마지막 좌표인경우 
			arr[n - 1][m - 1] = 0; // 마지막 좌표가 0인경우에 답 계산하고, 1인경우에 답 계산 
			if (isNemo() == false)
				answer++;

			arr[n - 1][m - 1] = 1;
			if (isNemo() == false)
				answer++;
			return;
		}

		arr[r][c] = 1; //해당 칸에 네모가 존재한다고 가정 
		if (c == m - 1) // 마지막 열이면 다음 행으로 넘겨준다 (열은 0번째 됨) 
			func(r + 1, 0);
		else //  마지막 열이 아니면 열만 한칸 증가시킨다. 
			func(r, c + 1);

		arr[r][c] = 0;//해당 칸에 네모가 존재하지 않는다고 가정 
		if (c == m - 1)
			func(r + 1, 0);
		else
			func(r, c + 1);

	}

	public static boolean isNemo() { // 네모가 존재하는지 확인하는  함수 
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < m - 1; j++) {
				if (arr[i][j] == 1 && arr[i + 1][j] == 1 && arr[i][j + 1] == 1 && arr[i + 1][j + 1] == 1)
					return true;

			}
		}
		return false;
	}

}
