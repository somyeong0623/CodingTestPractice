package Dec_week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 1068. 트리 
public class boj_1068 {
	static int n;
	static int cnt[]; // 자식의 수
	static int parent[]; // 부모가 몇번 노드인지 저장
	static ArrayList<Integer> list[]; // arraylist에 자식들 노드 번호 저장 
	static int target; // 삭제하는 노드 번호 
	static int answer; // 리프 노드의 갯수

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		cnt = new int[n];
		parent = new int[n];

		list = new ArrayList[n]; 
		// 리스트배열 초기화 
		for (int i = 0; i < n; i++) { 
			list[i] = new ArrayList<Integer>();
		}

		st = new StringTokenizer(br.readLine());
		target = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
//			list[i] = new ArrayList<Integer>(); // 6번째아래에 list[x].add(i) 코드가 있기 때문에 list[]를 미리 초기화 안하면 NullPointerError발생한다 
			int x = Integer.parseInt(st.nextToken()); //x: i번째 노드의 부모 번호 
			parent[i] = x; // 부모가 누구인지 번호 저장 
			if (x == -1)
				continue;
			cnt[x]++; // 자식 수 증가 
			list[x].add(i);
		}
		
		
		// 삭제하는 노드가 루트노드인경우 0출력하고 종료 
		if (parent[target] == -1) { 
			answer = 0;
			System.out.println(answer);
			return;
		}

		func(target);
		for (int i = 0; i < n; i++) {
			if (cnt[i] == 0)
				answer++;
		}
		System.out.println(answer);

	}

	public static void func(int x) {
		cnt[parent[x]]--; // 삭제된 노드의 부모의 자식수 1 감소 
		for (int i = 0; i < list[x].size(); i++) {
			int next = list[x].get(i);
			func(next); // 자식 타고 내려가면서 재귀 반복 
		}
	}

}
