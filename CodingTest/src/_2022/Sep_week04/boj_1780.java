package _2022.Sep_week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1780. 종이의 갯수 
public class boj_1780 {
	static int answer1, answer2, answer3;
	static int cnt1, cnt2, cnt3;
	static int n;
	static int arr[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n=Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		func(0,0,n);
		System.out.println(answer1);
		System.out.println(answer2);
		System.out.println(answer3);
		
	}
	public static void func(int r, int c, int size) { //현재함수에 해당하는 종이의 시작좌표, 한변의 길
		if(size==1) { //한변이 1이면 해당하는 숫자에 갯수 1개 추가하고 리턴 
			if(arr[r][c]==-1) answer1++;
			else if(arr[r][c]==0) answer2++;
			else answer3++;
			
			return;
		}
		
		cnt1=0; cnt2=0; cnt3=0; //현재 함수에 해당하는 종이에서 각각의 원소 갯수 확인 
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				if(arr[i][j]==-1) cnt1++;
				else if(arr[i][j]==0) cnt2++;
				else cnt3++;
			}
		}
		
		int multi=size*size; //종이에서의 원소 전체 갯수 
		if(cnt1==multi || cnt2==multi || cnt3==multi) { // 현재함수에 해당하는 종이가 모든 같은 수로 되어있는 경우 
			if(cnt1==multi) answer1++;
			else if(cnt2==multi) answer2++;
			else answer3++; 
		}else { // 다 같은수가 아닌 경우 
			int newSize=size/3;
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					func(r+i*newSize, c+j*newSize, newSize); // 9등분으로 나눠서 재귀함수 진행 
				}
			}
			
		}
		
	}
}
