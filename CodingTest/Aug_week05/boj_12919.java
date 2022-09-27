package Aug_week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//12919. A와 B 2 (T->S 로 가는 방식으로 해야 시간초과 안남 )
public class boj_12919 {
	static String s, t;
	static int answer;
	static boolean isSelected[];
	static boolean flag=false;

	public static void main(String[] args) throws IOException {
		long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		t = br.readLine();
		int cnt = t.length() - s.length();
		isSelected = new boolean[cnt];

//		subset(cnt, 0,flag);
		dfs(t);
		
		System.out.println(answer);
		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		long secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
		System.out.println("시간차이(m) : "+secDiffTime);
	}
	
	//경우를 고려하여 T->S로 만들기 (시간초과 안나고 통과)
	static void dfs(String s1) {
		if(s1.length()==s.length()) {
			if(s1.equals(s))
				answer=1;
			
			return;
		}
		
		if(s1.charAt(s1.length()-1)=='A') {
			dfs(s1.substring(0,s1.length()-1));
		}
		
		if(s1.charAt(0)=='B') {
			StringBuffer sb= new StringBuffer(s1); //문자열 reverse 하는 방법 
			String reverse = sb.reverse().toString();
			dfs(reverse.substring(0,reverse.length()-1));
		}
		
	}

	
	// 부분집합 이용해서 S->T로 만들기 (시간초과 2^50이니까 시간초과 )
	static void subset(int r, int index, boolean flag) {
		if(flag==true)
			return;
		
		if (index == r) {
			String s1 = s;
			String t1 = t;

			for (int i = 0; i < r; i++) {
				if (isSelected[i]) {
					s1 += 'A';
				} else {
					s1+='B';
					StringBuffer sb = new StringBuffer(s1); //문자열 reverse 하는방법 
					String reverse = sb.reverse().toString();
					s1=reverse;
				}
			}
			if(s1.equals(t1)) {
				answer=1;
				flag=true;
			}

			return;
		}

		isSelected[index] = true;
		subset(r, index + 1,flag);
		isSelected[index] = false;
		subset(r, index + 1,flag);
	}
}
