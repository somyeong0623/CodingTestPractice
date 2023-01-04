package _2022.Dec_week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1992. 쿼드트리 
public class boj_1992 {
	static int N;
	static int arr[][];
	static String answer="";
	static int one, zero;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr=new int[N][N];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				arr[i][j]=s.charAt(j)-'0'; // char를 int로 저장 
			}
		}
		recur(N,0,0);
		System.out.println(answer);
	}
	
	public static void recur(int n, int r, int c) { // n:현재 확인하는 정사각형의 한변의 길이. (r,c): 현재 확인하는 정사각형의 시작점 
		one=0; // 1의 갯수  
		zero=0;// 0의 갯수 
		
		for(int i=r; i<r+n; i++) { //0과 1의 갯수 세기 
			for(int j=c; j<c+n; j++) {
				if(arr[i][j]==1) one++;
				else zero++;
			}
		}
		if(one==n*n) { // 현재 확인하는 정사각형이 같은 수로 이루어져있으면 그 숫자를 정답문자열에 더하고 리턴 
			answer+='1';
			return;
		}
		if(zero==n*n) {
			answer+='0';
			return;
		}
		
		// 정사각형이 같은 수로 이루어져 있지 않으면 정답문자열에 열린괄호 더해주고 4분할해서 재귀 반복 
		answer+="(";
		recur(n/2, r,c);
		recur(n/2,r,c+n/2);
		recur(n/2,r+n/2,c);
		recur(n/2,r+n/2,c+n/2);
		answer+=")"; // 네등분한 정사각형에 대해 재귀 다 돌면 닫힌괄호 더해주기 .
		
	}

}
