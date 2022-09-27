package Sep_week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//1074.Z
public class boj_1074 {
	
	static int N,R,C;
	static int answer;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		int n1=(int)Math.pow(2, N);
		
		func(0,0,n1);	
		System.out.println(answer);
		
	
		
	}
	public static void func(int r, int c, int size) {
		if(size==1) //한변의 길이가 1이되면 리턴 
			return;
		
		int newSize= size/2;  //재귀마다 한변의 길이 반토막 
		if(R<r+newSize && C<c+newSize) { //4등분 했을때, (r,c)좌표의 위치가 1사분면일 경우 
			// answer  변화 없음
			func(r,c,newSize);
		}else if(R<r+newSize && C>=c+newSize) { //2사분면일 경우 
			answer+= newSize*newSize;
			func(r,c+newSize, newSize);
			
		}else if(R>=r+newSize && C<c+newSize) { //3사분면일 경
			answer+=newSize*newSize*2;
			func(r+newSize, c,newSize);
		}else {
			answer+=newSize*newSize*3;
			func(r+newSize, c+newSize, newSize);
		}
	}
	

}
