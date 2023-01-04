package _2022.Aug_week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_16926 {
	static int n, m, r; // 행,열,회전
	static int[][] arr;
	static ArrayList<Integer>[] list;
	static int[][] answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		arr = new int[n + 1][m + 1];
		answer = new int[n+1][m+1];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int min = Math.min(n, m);// n,m중에 작은 숫자
		int group=min/2; //그룹수 
		
		// 그룹별로 좌표상태를 담아놓을 리스트 
		list = new ArrayList[group];

		int index = 0;
		while (index < group) { // 2차원 배열의 좌표 상태를 -> 그룹별로 2차원 리스트에 옮기는 과정 
			list[index] = new ArrayList<>();
			int r = index;
			int c = index;

			list[index].add(arr[r][c]); //처음좌표 저장 
			while (true) { //오른쪽 방향 
				c++;
				list[index].add(arr[r][c]);
				if (c == m-index - 1)
					break;
			}
			while (true) { //아래방향 
				r++;
				list[index].add(arr[r][c]);
				if (r == n-index-1)
					break;
			}
			while (true) { //왼쪽방향 
				c--;
				list[index].add(arr[r][c]);
				if (c == index)
					break;

			}
			while (true) { //위쪽 방향 
				r--;
				if (r == index )
					break;
				list[index].add(arr[r][c]);
				
			}
			index++;

		}
		
		for(int cur=0;cur<group; cur++) { //각 그룹리스트 마다 회전시킨 상태를 리스트에 갱신해주기. 
			for(int i=0; i<r ;i++) { // 회전수(r)번 반복 .
				int temp=list[cur].get(0);
				list[cur].remove(0);
				list[cur].add(temp);
			}
		}
		
		index=0;
		while (index < group) { // 회전만큼 변경된 2차원 리스트를 2차원 배열로 옮기는 과정 
			int r = index;
			int c = index;
			int cur=0;
			answer[r][c]=list[index].get(cur++);
			while (true) {
				c++;
				answer[r][c]=list[index].get(cur++);
				if (c == m-index - 1)
					break;
			}
			while (true) {
				r++;
				answer[r][c]=list[index].get(cur++);
				if (r == n-index-1)
					break;
			}
			while (true) {
				c--;
				answer[r][c]=list[index].get(cur++);
				if (c == index)
					break;

			}
			while (true) {
				r--;
				if (r == index )
					break;
				answer[r][c]=list[index].get(cur++);
			
			}
			index++;

		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				sb.append(answer[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
		

	}
}
