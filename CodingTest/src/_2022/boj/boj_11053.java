package _2022.boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 11053.가장 긴 증가하는 부분수열 
public class boj_11053 {
	static int N;
	static int arr[];
	static int cnt[];
	static int answer;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N=Integer.parseInt(br.readLine());
		arr=new int[N];
		cnt=new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int temp=0;
		
		for(int i=0; i<N; i++) {
			cnt[i]=1;
			for(int j=0; j<i; j++) {
				if(arr[j]<arr[i] && cnt[i]<cnt[j]+1)
					cnt[i]=cnt[j]+1;
			}
			answer=Math.max(answer, cnt[i]);
		}
		
//		System.out.println(Arrays.toString(cnt));
		System.out.println(answer);
	}

}
