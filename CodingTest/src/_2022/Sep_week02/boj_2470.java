package _2022.Sep_week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//2470. 두 용액 
public class boj_2470 {
	static int n;
	static int arr[];
	static int min=Integer.MAX_VALUE;
	static int answer1, answer2;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n=Integer.parseInt(br.readLine());
		arr= new int[n];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr); //오름차순 정렬 
		
		int start=0;
		int end=n-1;
		
		while(start<end) { //start==end이면 안되는것 주의 
			int sum=arr[start]+arr[end];
			
			if(Math.abs(sum)<min) { // 두 용액 합의 절댓값의 최솟값 갱신 
				min=Math.abs(sum);
				answer1=arr[start]; 
				answer2=arr[end];
			}
			
			if(sum==0) // 이부분 처리 안하면 시간초과 난다. 
				break;
			else if(sum>0) // 두 용액의 합이 양수면 end가 작아지는 방향으로 
				end--;
			else if(sum<0) // 두 용액의 합이 음수이면 start가 커지는 방향으로 
				start++;
		}
		System.out.println(answer1+" "+answer2);
	}
}
