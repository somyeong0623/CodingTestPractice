package Sep_week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//16987. 계란으로 계란치기  (진짜모르겠다)
public class boj_16987 {
	static class Egg {
		int d;
		int weight;

		public Egg() {
		}

		public Egg(int d, int weight) {
			this.d = d;
			this.weight = weight;
		}
	}

	static int n;
	static Egg[] eggs;
	static boolean broken;
	static int answer, cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		eggs = new Egg[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			eggs[i] = new Egg(x, y);
		}
		dfs(0);
		System.out.println(answer);

	}

	public static void dfs(int left) {// left: 이번에 들어야할 계란의 인덱스, cnt:현재까지 깨진 계란 수
		if (left >= n) { // 이번 타임에 든 계란이 가장 오른쪽 계란일 경우 종
			cnt = 0;
			for (int i = 0; i < n; i++) {
				if (eggs[i].d <= 0)
					cnt++;
			}

			answer = Math.max(answer, cnt);
			return;
		}
		// 칠 수 있는 계란 확인
		int temp = 0;
		for (int i = 0; i < n; i++) {
			if (eggs[i].d <= 0) {
				temp++;
				// 나머지를 전부 때릴 수 없을 때
				if (temp == n - 1) {
					dfs(left + 1);
					return;
				}
				continue;
			}
		}

		if (eggs[left].d <= 0) {
			dfs(left + 1);
			return;
		}

		broken = false;
		for (int i = 0; i < n; i++) {
			if (i == left)
				continue; // 자기자신이면 넘어가기

			if (eggs[left].d > 0 && eggs[i].d > 0) {
				eggs[left].d -= eggs[i].weight;
				eggs[i].d -= eggs[left].weight;
				broken = true;
				dfs(left + 1);
				eggs[left].d += eggs[i].weight;
				eggs[i].d += eggs[left].weight;
			}
		}
		if (broken == false) {
			dfs(left + 1);
			return;
		}

	}

}
