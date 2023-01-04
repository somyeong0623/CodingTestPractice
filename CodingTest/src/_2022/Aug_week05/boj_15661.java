package _2022.Aug_week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//15661. 링크와 스타트 
public class boj_15661 {
	static int n;
	static int arr[][];
	static int answer=Integer.MAX_VALUE;
	static boolean isSelected[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n=Integer.parseInt(br.readLine());
		arr = new int[n+1][n+1];
		isSelected= new boolean[n+1];
		
		for(int i=1; i<=n; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		//팀원 나눌수있는 케이스수 , 예를들어 5명이면 5C1, 5C2까지 살펴보면됨 (한 팀 뽑으면 나머지사람이 자동으로 상대팀 되니까)
		int case_cnt=n/2;
		for(int i=1; i<=case_cnt; i++) {
			comb(i,0,1); //r, cnt, start
		}
		System.out.println(answer);
	}
	static void comb(int r, int cnt,int start) {
		if(cnt==r) {
			int sum1=0, sum2=0; //1번팀의 능력치합, 2번팀의 능력치합 
			ArrayList<Integer> team1= new ArrayList<Integer>(); 
			ArrayList<Integer> team2= new ArrayList<Integer>();
			//각 팀에 속하는 사람번호 집어넣기 
			for(int i=1; i<=n; i++) {
				if(isSelected[i])
					team1.add(i);
				else
					team2.add(i);
			}
			
			
//			if(team1.size()==0 || team2.size()==0) //조합으로했으니까 공집합리 없어서 이코드 없어도됨 
//				return;
			
			//team1의 능력치 합 구하기 
			for(int i=0;i<=team1.size()-1; i++) {
				for(int j= i+1; j<team1.size(); j++) {
					sum1+=arr[team1.get(i)][team1.get(j)];
					sum1+=arr[team1.get(j)][team1.get(i)];
				}
			}
			
			//team2의 능력치 합 구하기 
			for(int	i=0;i<=team2.size()-1; i++) {
				for(int j= i+1; j<team2.size(); j++) {
					sum2+=arr[team2.get(i)][team2.get(j)];
					sum2+=arr[team2.get(j)][team2.get(i)];
				}
			}
			
			answer=Math.min(answer, Math.abs(sum1-sum2)); //최솟값으로 정답 갱신 
			
			return;
		}
		for(int i=start; i<=n; i++) {
			if(isSelected[i])
				continue;
			isSelected[i]=true;
			comb(r,cnt+1,i+1);
			isSelected[i]=false;
		}
		
	}
}
