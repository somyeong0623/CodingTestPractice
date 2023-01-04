package _2022.Sep_week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//16235.나무 재테크 
public class boj_16235 {

	static class Info {
		int amount; // 남아있는 양분
		int A; // 매년 추가되는 양분
		ArrayList<Tree> treeList;

		public Info(int amount, int A) {
			this.amount = amount;
			this.A = A;
			treeList = new ArrayList<Tree>();
		}

		@Override
		public String toString() {
			return "Info [amount=" + amount + ", A=" + A + ", treeList=" + treeList + "]";
		}

	}

	static class Tree implements Comparable<Tree> {
		int age;
		boolean live; // 살아있는지 죽어있는지

		public Tree(int age) {
			this.age = age;
			this.live = true; // 살아있음이 디폴트
		}

		public int compareTo(Tree o) {
			return this.age - o.age;// age기준 오름차순 정렬
		}

		@Override
		public String toString() {
			return "Tree [age=" + age + ", live=" + live + "]";
		}
		

	}

	static int N, M, K; // N: 배열크기, M:나무 갯수, K:몇년인지
	static Info[][] arr; // 해당 좌표에 있는 양분, 나무 정보
	static int A[][];
	static int tree_r, tree_c, tree_age;
	static int answer; // 살아있는 나무의 갯수
	static int dr[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int dc[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new Info[N][N];
		A = new int[N][N];
		answer = M; //answer: 나무 갯수 

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int x = Integer.parseInt(st.nextToken());
				arr[i][j] = new Info(5, x); // 처음에 칸에 존재하는 양분 : 5
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			tree_r = Integer.parseInt(st.nextToken());
			tree_c = Integer.parseInt(st.nextToken());
			tree_age = Integer.parseInt(st.nextToken());

			arr[tree_r-1][tree_c-1].treeList.add(new Tree(tree_age)); //Info배열은 인덱스 0부터 시작이므로 
		}

		for (int t = 0; t < K; t++) { // K년동안 반복
			spring();
			summer();
			fall();
			winter();
			
		}
		
		
		System.out.println(answer);

	}
	/*
	 * 1.봄에는 나무가 자신의 나이만큼 양분을 먹고, 나이가 1 증가한다. 각각의 나무는 나무가 있는 1×1 크기의 칸에 있는 양분만 먹을 수
	 * 있다. 하나의 칸에 여러 개의 나무가 있다면, 나이가 어린 나무부터 양분을 먹는다. 만약, 땅에 양분이 부족해 자신의 나이만큼 양분을 먹을
	 * 수 없는 나무는 양분을 먹지 못하고 즉시 죽는다.
	 */
	public static void spring() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ArrayList<Tree> curTreeList = arr[i][j].treeList;
				Collections.sort(curTreeList); // 해당좌표의 나무리스트를 나이 오름차순으로 정렬
				if (curTreeList.size() > 0) {
					for (int k = 0; k < curTreeList.size(); k++) {
						Tree curTree = curTreeList.get(k); // 현재 확인하고 있는 나무
						if (arr[i][j].amount - curTree.age >= 0) {
							arr[i][j].amount -= curTree.age;
//							curTree.age++; // 나이 1 증가
							curTreeList.get(k).age++;
						} else {
							curTree.live = false; // 자기 나이만큼 양분을 먹을수 없으면 죽음
							answer--; //나무 갯수 감소 
						}
					}
				}
			}
		}
	}

	/*
	 * 여름에는 봄에 죽은 나무가 양분으로 변하게 된다. 각각의 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가된다. 소수점
	 * 아래는 버린다.
	 */
	public static void summer() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ArrayList<Tree> curTreeList = arr[i][j].treeList;
				for (int k = 0; k < curTreeList.size(); k++) {
					Tree curTree = curTreeList.get(k);
					if (curTree.live == false) {
						arr[i][j].amount += curTree.age / 2;
						curTreeList.remove(k); // 양분으로 변하게 한 후 나무리스트에서 해당 나무 삭제
						k--; // 하나 삭제했으니까 인덱스 조절해주기
					}
				}
			}
		}
	}

	/*
	 * 가을에는 나무가 번식한다. 번식하는 나무는 나이가 5의 배수이어야 하며, 인접한 8개의 칸에 나이가 1인 나무가 생긴다. 어떤 칸 (r,
	 * c)와 인접한 칸은 (r-1, c-1), (r-1, c), (r-1, c+1), (r, c-1), (r, c+1), (r+1, c-1),
	 * (r+1, c), (r+1, c+1) 이다. 상도의 땅을 벗어나는 칸에는 나무가 생기지 않는다.
	 */
	public static void fall() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ArrayList<Tree> curTreeList = arr[i][j].treeList;
				for (int k = 0; k < curTreeList.size(); k++) {
					Tree curTree = curTreeList.get(k);
					if (curTree.age % 5 == 0) {
						for (int d = 0; d < 8; d++) {
							int nr = i + dr[d];
							int nc = j + dc[d];
							if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
								arr[nr][nc].treeList.add(new Tree(1)); // 나이가 1인 나무 생성
								answer++; // 나무 갯수 증가 
							}
						}
					}
				}
			}
		}
	}

	/*
	 * 겨울에는 S2D2가 땅을 돌아다니면서 땅에 양분을 추가한다. 각 칸에 추가되는 양분의 양은 A[r][c]이고, 입력으로 주어진다.
	 */
	public static void winter() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				arr[i][j].amount+=arr[i][j].A;
			}
		}
	}
}
