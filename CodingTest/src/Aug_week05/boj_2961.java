package Aug_week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2961. 도영이가 만든 맛있는 음식 
public class boj_2961 {
	static class Food {
		int s, b;

		public Food(int s, int b) {
			this.s = s;
			this.b = b;
		}

		@Override
		public String toString() {
			return "Food [s=" + s + ", b=" + b + "]";
		}

	}

	static int n;
	static long answer = Long.MAX_VALUE;
	static boolean[] isSelected;
	static Food list[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());

		list = new Food[n + 1];
		isSelected = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[i] = new Food(s, b);

		}
//		for (int i = 0; i <= n; i++) {
//			System.out.println(list[i]);
//		}

		subset(n, 1);
		System.out.println(answer);
	}

	static void subset(int r, int index) {
		if (index == r + 1) { // index가 1부터시작하니까 r+1로 설정
			long mul = 1, sum = 0; //  mul: 신맛의 곱, sum: 쓴맛의 합 
			for (int i = 1; i <= n; i++) {
				if (isSelected[i]) {
					mul *= list[i].s;
					sum += list[i].b;
				}
			}
			if (!(mul == 1 && sum == 0)) { //공집합이면(== sum,mul에 변화 없으면) 패스 
				if (answer > Math.abs(sum - mul))
					answer = Math.abs(sum - mul);
			}
//			isSelected = new boolean[n + 1]; // 하나의 부분집합 살펴봤으면 isSelected 초기화해주기 (이거왜해!! ㅡㅡ 하지마 )
			return; 
		}
		isSelected[index] = true;
		subset(r, index + 1);
		isSelected[index] = false;
		subset(r, index + 1);
	}
}
