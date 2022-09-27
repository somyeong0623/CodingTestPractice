package Sep_week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//2110. 공유기 설치  (몰라서 구글링 도움받음 ) 
public class boj_2110 {

	static int n, c;
	static int home[];
	static int answer = 0;
	static int minGap, maxGap;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		home = new int[n];

		for (int i = 0; i < n; i++) {
			home[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(home);
		minGap=0;
		maxGap=home[n-1]-home[0];
		int mid=0;
		
		while(minGap<=maxGap) {
			mid=(minGap+maxGap)/2;
			
			int cur=0;
			int cnt=1; // 맨앞 집에는 무조건 설치했다고 가정
			for(int i=1; i<n; i++) {
				if(home[i]-home[cur]>=mid) {
					cnt++;
					cur=i;
					
				}
			}
		
			if(cnt>=c) {
				minGap=mid+1;
				answer=mid;
			}else {
				maxGap=mid-1;
			}
		}
		
		System.out.println(answer);
	}
	
	
}
