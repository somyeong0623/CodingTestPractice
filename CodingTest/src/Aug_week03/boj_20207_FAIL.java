package Aug_week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//20207. 달력 
/*
일정 갯수 1<=N<=1000
일정 시작날짜 S, 종료 날짜 E
1<=S<=E<=365
 */
class Plan implements Comparable<Plan> {
	int s;
	int e;

	public Plan(int s, int e) {
		super();
		this.s = s;
		this.e = e;
	}

	@Override
	public int compareTo(Plan o) {
		if (s == o.s)
			return o.e - e; // e 기준 내림차순
		return s - o.s; // s 기준 오름차순
	}

	@Override
	public String toString() {
		return "Plan [s=" + s + ", e=" + e + "]";
	}

}

class Info {
	int start;
	int end;
	int height;
	public Info(int start, int end, int height) {
		super();
		this.start = start;
		this.end = end;
		this.height = height;
	}
	
	

}

public class boj_20207_FAIL {
	static int N;
	static int s, e;
	static ArrayList<Plan> plans;
	static ArrayList<Plan> answers;
	static int min, max;
	static int[][] calendar;

	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N=Integer.parseInt(br.readLine());
		plans= new ArrayList<>();
		answers=new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			s=Integer.parseInt(st.nextToken());
			e=Integer.parseInt(st.nextToken());
			plans.add(new Plan(s,e));
		}
		Collections.sort(plans);
		for(Plan p : plans) {
			if(p.)
		}
		
	}
}
