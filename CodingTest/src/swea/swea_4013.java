package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//4013. 특이한 자석 (모의역테) 
public class swea_4013 {
	static int TC, K;
	static int magnet[][];
	static boolean isRotate;
	static boolean flag[];
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {

			answer = 0;
			K = Integer.parseInt(br.readLine());
			magnet = new int[5][8];

			// 자석 정보 입력
			for (int i = 1; i <= 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					magnet[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 회전 정보 입력
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());

				isRotate = false;
				flag = new boolean[5];
				
				//num의 왼쪽 자석들 체크 
				flag[num]=true;
				for(int d=num; d>=2; d--) {
					if(magnet[d-1][2]!=magnet[d][6] && flag[d]) flag[d-1]=true;
//					System.out.println("d-1: "+(d-1)+", d: "+d +", flag[d-1]="+flag[d-1]);
				}
				//num의 오른쪽 자석들 체크 
				for(int d=num; d<=3; d++) {
					if(magnet[d][2]!=magnet[d+1][6] && flag[d] ) flag[d+1]=true;
//					System.out.println("d: "+d+", d+1: "+(d+1) +", flag[d+1]="+flag[d+1]);
				}
					
				int temp = num%2;
				for (int j = 1; j < 5; j++) {
					if(flag[j] && temp == j%2) { // 기준 방향 -dir
						rotate(j,dir);
					}else if(flag[j] && temp != j%2) { 
						rotate(j,dir*(-1));
					}
				}
//			
			} // 회전 정보 for 문

			if (magnet[1][0] == 1)
				answer += 1;
			if (magnet[2][0] == 1)
				answer += 2;
			if (magnet[3][0] == 1)
				answer += 4;
			if (magnet[4][0] == 1)
				answer += 8;

			System.out.println("#" + t + " " + answer);
		} // TC for 문
	}

	public static void rotate(int num, int dir) { // dir 1 : 시계방향, dir -1 : 반시계 방향 
		if (dir == 1) { // 시계방향
			int temp = magnet[num][7];
			for (int d = 7; d >= 1; d--) {
				magnet[num][d] = magnet[num][(d + 8 - 1) % 8];
			}
			magnet[num][0] = temp;
		} else { // dir==-1. 반시계 방향
			int temp = magnet[num][0];
			for (int d = 0; d < 7; d++) {
				magnet[num][d] = magnet[num][(d + 1) % 8];
			}
			magnet[num][7] = temp;
		}

	}

}
