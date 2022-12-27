package Dec_week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//2110.공유기 설치 
public class boj_2110 {
	
	static int N,C;
	static int arr[];
	static int start,end,mid;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		
		arr=new int[N];
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		end=arr[N-1]-arr[0]; //가장 앞집과 가장 뒷집 사이의 거리를 인접한 거리의 최댓값으로 잡음. 
		start=1; // 인접한 거리의 최솟값은 1 .
	
		while(start<=end) {
			mid=(start+end)/2;
			if(count(mid)>=C){ // C개 이상 지을수 설치할 수 있으면 인접한 거리의 길이를 늘리는 방향으로. 
				start=mid+1;
				answer=Math.max(answer, mid);
			}else { // C개 미만으로  지을수 설치할 수 있으면 인접한 거리의 길이를 줄이는 방향으로. 
				end=mid-1;
			} 
		}
		System.out.println(answer);
	
	}
	public static int count(int mid) { // 인접한 사이의 거리가 mid일 때, 
		int count=1; 
		int lastLocate=arr[0]; // 맨 앞 집에는 무조건 설치했다고 가정.
		
		for(int i=1; i<N; i++) {
			
			if(arr[i]-lastLocate>=mid) {
				count++;
				lastLocate=arr[i];
			}
			
		}
		return count;
	}
}
