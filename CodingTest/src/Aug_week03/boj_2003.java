package Aug_week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//2003. 수들의 합 2
/*
 * 수열길이 1<=N<=10,000
 * 수들의합 1<=M<=300,000,000
 * A[x] <=30,000인 자연수 
 */
public class boj_2003 {
	
	static int N,M;
	static int[] arr; 
	static int answer; 
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		arr=new int[N];
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int start=0, end=0, sum=0;
		while(true) {
			if(sum>=M) {
				if(sum==M) {
					answer++;
					System.out.println("start = "+start +", end = " +end);
				}
				
				sum-=arr[start++];
			}else {
				if(end==N)
					break;
				
				sum+=arr[end++];
					
			}
		}
		
		System.out.println(answer);
	}
}
