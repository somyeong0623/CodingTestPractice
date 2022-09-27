package Aug_week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2559. 수열
/*
 * 날짜수 2<=N<=100,000
 * 연속적인 날짜 수 1<=K<=N
 * -100<=각 온도<=100
 */

public class boj_2559 {
	static int N,K;
	static int[] arr;
	static int answer=Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		arr=new int[N];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int start=0;
		int end=start+K-1;
		int sum=0;
		for(int i=start; i<=end; i++) {
			sum+=arr[i];
		}
		while(true) {
			if(sum>answer)
				answer=sum;
			
			if(end==N-1)
				break;
			sum-=arr[start];
			start++;
			end++;
			sum+=arr[end];
		}
		
		System.out.println(answer);
	}
}
