package _2022.Sep_week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//14888. 연산자 끼워넣기 	
public class boj_14888 {
	static int n;
	static int numbers[];
	static int oper[];
	static int answerMin=Integer.MAX_VALUE;
	static int answerMax=Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n=Integer.parseInt(br.readLine());
		numbers= new int[n];
		oper=new int[4];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			numbers[i]=Integer.parseInt(st.nextToken());
		}
		st=new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			oper[i]=Integer.parseInt(st.nextToken());
		}
		
		dfs(1,numbers[0],oper); //시작할때의 sum=numbers[0]이므로 index는 1부터시작
		System.out.println(answerMax);
		System.out.println(answerMin);
		
	}
	public static void dfs(int index, int sum, int[] oper) {
		if(index==n) {
			answerMin=Math.min(answerMin, sum);
			answerMax=Math.max(answerMax, sum);
			return;
		}
		
		if(oper[0]>0) {
			oper[0]--;
			dfs(index+1,sum+numbers[index],oper);
			oper[0]++;
		}
		if(oper[1]>0) {
			oper[1]--;
			dfs(index+1,sum-numbers[index],oper);
			oper[1]++;
		}
		if(oper[2]>0) {
			oper[2]--;
			dfs(index+1,sum*numbers[index],oper);
			oper[2]++;
		}
		if(oper[3]>0) {
			oper[3]--;
			dfs(index+1, sum/numbers[index],oper);
			oper[3]++;
		}
//		return; 
		//n-1번 연산을 끝내기 전에 연산자 수가 모자르는 경우도 있을 줄 알고 retrun을 했었는데 
		//문제를 보면 숫자 N개, 연산자 N-1개로 고정이 되어있어서 return은 할 필요 없다.
	}
}
