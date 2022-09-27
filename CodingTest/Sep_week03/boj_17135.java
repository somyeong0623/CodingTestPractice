package Sep_week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

//17135. 캐슬 디펜스 
public class boj_17135 {
	static class Point{
		int r, c;
		public Point(int r,int c) {
			this.r=r;
			this.c=c;
		}
	}
	static class Info implements Comparable<Info> {
		int r, c, dist;

		public Info(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
		public int compareTo(Info o) { // 거리 오름차순, 열 오름차순
			if (this.dist == o.dist)
				return this.c - o.c;

			return this.dist - o.dist;
		}

		@Override
		public String toString() {
			return "Info [r=" + r + ", c=" + c + ", dist=" + dist + "]";
		}
	}

	static int n, m, D;
	static int arr[][];
	static int origin[][];
	static int numbers[];
	static boolean isSelected[];
	static int die_cnt, answer;
	static ArrayList<Info> monsters;
	static ArrayList<Info> targets;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		arr = new int[n][m]; // 마지막 행은 궁수가 위치한 칸
		origin = new int[n][m];
		numbers = new int[3];
		isSelected = new boolean[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				origin[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		comb(0, 0); 
		System.out.println(answer);
	}
	
	//0~m-1번까지의 행 중에서 3개 선택하는 조합  
	public static void comb(int cnt, int start) { //현재까지 뽑은 갯수 , 배열의 시작지점 

		if (cnt == 3) {
			//조합 선정이 완료되면 시뮬레이션 시작 
			simulate(numbers); 
			answer = Math.max(answer, die_cnt);
			return;
		}
		for (int i = start; i < m; i++) { // 여기 조건을 n으로 해서 틀림. 열중에 3개 선택하는거니까 m으로 해야함!! 

			numbers[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}

	
	public static void simulate(int[] numbers) {
		die_cnt = 0; // 죽인 적 수 초기화 
		arrCopy(); 	//시뮬레이션 시작 시에, 앞으로 쓸 arr[][] 배열에 원본배열 복사 
		
		while (true) {
			targets = new ArrayList<Info>(); // 3명의 궁수를 탐색하면서 죽일수 있는 적을 저장해두는 리스트 
			if (existMonsters() == false) { // 죽일 수 있는 적이 없으면 while문 끝내기 
				break;
			}
			for (int i = 0; i < 3; i++) {
				getMonsters(n, numbers[i]); // 궁수의 행,열 좌표
				if (monsters.size() == 0) // 제거할수 있는 적 없으면패스
					continue;

				Collections.sort(monsters); // 거리 적은순, 행이 왼쪽에 가까 순으로 정렬 
				Info monster = monsters.get(0); // 가장 우선순위 높은 몬스터(적) 선택 

				// 적을 제거하는 부분 
				// 이때 바로 적을제거하면 안된다. 
				//왜냐하면 여러명의 궁수가 같은 적을 제거하려고 할 경우가 있기 때문이다. 
				//궁수 3명을 확이하면서 각자 제거하려는 적을 리스트에 담아놓은 후, 궁수를 도는 포문이 끝나고 나면 적을 제거해준다.
				
//				arr[monster.r][monster.c] = 0; (이렇게 하면 안됨)
				targets.add(new Info(monster.r, monster.c, monster.dist));
				

			}
			for(int i=0; i<targets.size(); i++) {
				Info cur = targets.get(i);
				if(arr[cur.r][cur.c]==1) { 
					arr[cur.r][cur.c]=0;
					die_cnt++; //제거한 적의 수 카운트 
				}
			}
			move(); // 적이 한칸 아래로 이동 
		} 

	}

	public static void getMonsters(int r, int c) {
		monsters = new ArrayList<Info>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 1) {
					int d = Math.abs(r - i) + Math.abs(c - j);
					if (d <= D)
						monsters.add(new Info(i, j, d));
				}
			}
		}
	}

	public static boolean existMonsters() {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 1)
					cnt++;
			}
		}
		if (cnt > 0)
			return true;
		else
			return false;
	}

	// 적이 한칸 아래로 이동
	// N*M 배열 전체를 아래로 한칸 이동시키고 맨 윗줄을 0으로 채워넣었다.
	public static void move() {
		for (int i = n - 1; i >= 1; i--) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = arr[i - 1][j];
			}
		}
		// 맨 윗줄 0으로 처리
		for (int i = 0; i < m; i++) {
			arr[0][i] = 0;
		}
	}
	
	//시뮬레이션 시작 시에, 앞으로 쓸 arr[][] 배열에 원본배열 복사 
	public static void arrCopy() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = origin[i][j];
			}
		}
	}

	
	public static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	

}
