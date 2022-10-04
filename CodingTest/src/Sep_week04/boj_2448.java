package Sep_week04;

import java.util.Scanner;

//2448. 별찍기 (모르겠어서 구글링 참고) 
public class boj_2448 {
	static int N;
	static char arr[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb= new StringBuilder();
		N = sc.nextInt();
		
		arr=new char[N][2*N-1];
		for(int i=0; i<N; i++) {
			for(int j=0; j<2*N-1; j++)
				arr[i][j]=' ';
		}
		
		func(0,N-1,N);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<2*N-1; j++)
				sb.append(arr[i][j]);
			sb.append("\n");
		}
		System.out.println(sb); // StringBuilder를 써서 시간초과를 해결했다. 
		
	}
	
	public static void func(int r, int c, int size) {
		if(size==3) {
			arr[r][c]='*';
			arr[r+1][c-1]=arr[r+1][c+1]='*';
			arr[r+2][c-2]=arr[r+2][c-1]=arr[r+2][c]=arr[r+2][c+1]=arr[r+2][c+2]='*';
			
			return;
		}
		int newSize=size/2;
		func(r,c,newSize);
		func(r+newSize,c-newSize,newSize);
		func(r+newSize,c+newSize,newSize);
		
		
	}

}
