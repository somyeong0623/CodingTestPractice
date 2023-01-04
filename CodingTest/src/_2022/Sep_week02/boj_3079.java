package _2022.Sep_week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

//3079. 입국 심사 
public class boj_3079 {
	static int n,m; // 심사대갯수, 사람수 
	static int arr[]; // 심사대가 심사하는데 걸리는 시간 
	static long answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		arr=new int[n];
		for(int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		long start=0L;
		long end=arr[n-1]*1000000000L; //여기를 이렇게 안하니까 오류남..왠지 모르겠음 
		long  mid=0L;
		
		while(start<=end) {
			mid=(start+end)/2;
			if(getCnt(mid)>=m) {
				answer=mid;
				end=mid-1;
			}
			else
				start=mid+1;
			System.out.println("mid : "+mid);
				
		}
		
//		while(true){
//			if(getCnt(mid-1)<m)
//				break;
//			mid--;
//		}
		System.out.println(answer);
		
	}
	
	static public long getCnt(long mid) {
		long sum=0;
		for(int i=0; i<n; i++) {
			sum+=mid/arr[i];
		}
		return sum;
	}
}
