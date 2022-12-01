import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_11053_binary {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr= new int[n];
		int[] dp = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int size=0;
		for(int i=0; i<n; i++) {
			int x= Arrays.binarySearch(dp, 0, size, arr[i]);
//			System.out.println("x: " +x);
			if(x>=0) continue;
			
			int index=Math.abs(x)-1;
			dp[index]=arr[i];
			if(index==size) size++;
		}
		System.out.println(size);
	
	}

}
