package Sep_week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1074 {
	
	static int n,r,c;
	static int arr[][];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		int n1=(int)Math.pow(2, n);
		arr= new int[n1][n1];
		
		func(0,0,n1/2,0);
//		for(int i=0; i<n1; i++) {
//			for(int j=0; j<n1; j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		
	}
	public static void func(int r_,int c_, int half,int num) { //half: 현재 보고있는 정사각형 한변의 길이의 반 
		if(half==1) {
			
			arr[r_][c_]=num;
			arr[r_][c_+1]=num+1;
			arr[r_+1][c_]=num+2;
			arr[r_+1][c_+1]=num+3;
			if(arr[r][c]!=0) {
				System.out.println(arr[r][c]);
				System.exit(0);
			}
			
			return;
		}
		
		
		func(r_,c_,half/2,num);
		func(r_,c_+half,half/2,num+half*half);
		func(r_+half,c_,half/2,num+2*half*half);
		func(r_+half, c_+half, half/2,num+3*half*half);
		
	}

}
