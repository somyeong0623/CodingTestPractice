package Aug_week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_16926_GOOD {
	static int n, m, r; // 행,열,회전
	static int[][] arr;
	static int dr[] = {0,1,0,-1}; //우상좌하
	static int dc[]= {1,0,-1,0}; //우상좌하 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		arr = new int[n + 1][m + 1];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int min = Math.min(n, m);// n,m중에 작은 숫자
		int group=min/2; //그룹수 (테두리별로 같은 그룹) 
		
		//회전 횟수
		for(int i=0; i<r; i++) {
			
			//그룹수 만큼 반복
			for(int g=0; g<group; g++) {
				int r=g;
				int c=g;
				
				
				//각 그룹의 첫번째 값 따로 저장
				int first= arr[r][c];
				
				int idx=0; //방향 
				while(idx<4) {
					int nr= r+dr[idx];
					int nc= c +dc[idx];
					
					//범위 내에 있을경우 돌리기 
					if(nr>=g && nc>=g && nr<n-g && nc<m-g) {
						arr[r][c]=arr[nr][nc];
						r=nr;
						c=nc;
						
					} else
						idx++; //범위 벗어나면 방향 전환 
				}
				
				arr[g+1][g]=first; //그룹의 마지막 좌표에 그룹의 처음값 대입 
				
			}
		}
		
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				sb.append(arr[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
		
}
