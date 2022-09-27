package Aug_week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//15787. 기차가 어둠을 헤치고 은하수를 
/*
기차 수 1<=N<=100,000
명령 수 1<=M<=100,000 
1 i x : i번째 기차에(1 ≤ i ≤ N) x번째 좌석에(1 ≤ x ≤ 20) 사람을 태워라. 이미 사람이 타있다면 , 아무런 행동을 하지 않는다.
2 i x : i번째 기차에 x번째 좌석에 앉은 사람은 하차한다. 만약 아무도 그자리에 앉아있지 않았다면, 아무런 행동을 하지 않는다.
3 i : i번째 기차에 앉아있는 승객들이 모두 한칸씩 뒤로간다. k번째 앉은 사람은 k+1번째로 이동하여 앉는다. 만약 20번째 자리에 사람이 앉아있었다면 그 사람은 이 명령 후에 하차한다.
4 i : i번째 기차에 앉아있는 승객들이 모두 한칸씩 앞으로간다. k번째 앉은 사람은 k-1 번째 자리로 이동하여 앉는다. 만약 1번째 자리에 사람이 앉아있었다면 그 사람은 이 명령 후에 하차한다.
  
 */
public class boj_15787 {
	static int N, M; // 기차 수, 명령 수
	static int command, num, seat;
	static int [][] train;
	static int answer; //정답 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		train = new int[N+1][21];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			command = Integer.parseInt(st.nextToken());
			
			switch (command) {
			case 1: // num 기차의 seat번째 좌석에 사람 태우기 
				num=Integer.parseInt(st.nextToken());
				seat=Integer.parseInt(st.nextToken());
				
				if(train[num][seat]==1) //이미 타있으면 패스 
					continue;
				else
					train[num][seat]=1;
				break;
			case 2: //num 기차의 seat번째 좌석에 사람 하차시키기 
				num=Integer.parseInt(st.nextToken());
				seat=Integer.parseInt(st.nextToken());
				
				if(train[num][seat]==0) // 사람 없으면 패스 
					continue; 
				else //사람 있으면 하차시키기 
					train[num][seat]=0; 
				break;
			case 3: // 승객 한칸씩 뒤로 
				num=Integer.parseInt(st.nextToken());
				for(int j=20; j>=2; j--) {
					train[num][j]=train[num][j-1];
				}
				train[num][1]=0;
				break;
			default: // 승객 한칸씩 앞으로 
				num=Integer.parseInt(st.nextToken());
				for(int j=1; j<=19; j++) {
					train[num][j]=train[num][j+1];
				}
				train[num][20]=0;
				break;
			}

		}
		
		//String Set에 2차원 int배열을 String형으로 변환해서 넣기
		//Set은 중복을 허용하지 않으므로, 서로 다른 형태의 갯수가 set.size() 이다.
		Set<String> set = new HashSet<>();
		for(int i=1; i<=N; i++) {
			String s =Arrays.toString(train[i]);
			System.out.println(s);
			set.add(s);
		}
//		System.out.println(set.size());
		sb.append(set.size());
		System.out.println(sb);
		
	}

}
