package _2022.Aug_week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//2531. 회전초밥 
/*
 *  회전 초밥 벨트에 놓인 접시의 수 N,
 *  초밥의 가짓수 d
 *  연속해서 먹는 접시의 수 k
 *  쿠폰 번호 c
 *  2≤ N ≤ 30,000
 *  2 ≤ d ≤ 3,000
 *  2 ≤ k ≤ 3,000 (k ≤ N)
 *  1 ≤ c ≤ d
 * 
 */

public class boj_2531 {
	
	static int N,d,k,c,answer;
	static int[] arr;
	
	//menuList(리스트) : 손님이 고른 메뉴의 종류를 관리함
	//menuCount(배열): 손님이 고른 메뉴의 갯수를 관리함 
	static ArrayList<Integer> menuList;
	static int[] menuCount;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		menuList = new ArrayList<>();
		
		N=Integer.parseInt(st.nextToken());
		d=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		arr = new int[N];
		menuCount= new int[d+1];
		
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		//초기 세팅: 처음 k개의 메뉴 리스트에 넣어주기 
		for(int i=0; i<k; i++) {
			if(menuList.contains(arr[i])==false) { //고르지 않은 메뉴면 리스트에 추가하고, count를 1로 설정 
				menuList.add(arr[i]);
				menuCount[arr[i]]=1; 
			}
			else
				menuCount[arr[i]]++; //이미 고른메뉴면 count만 올려주기 
		}
		
		//초기 answer 설정 
		if(menuList.contains(c)==false)
			answer=menuList.size()+1;
		else
			answer=menuList.size();
		
		//첫원소 빼고 k번다음 원소 넣는 과정 ->  N번 하면서 최댓값 체크 
		//연속된 k개를 고르는 과정이 가능한 경우를 전부 해보면서 정답을 확인해야 하기 때문에. 
		for(int i=0; i<N; i++) {  
			
			if(menuCount[arr[i]]>=2)
				menuCount[arr[i]]--;
			else
				menuList.remove(Integer.valueOf(arr[i]));
			
			int next= arr[(i+k)%N]; //회전을 위해 mod연산 사용 
			if(menuList.contains(next)==false) {
				menuList.add(next);
				menuCount[next]=1;
			}
			else
				menuCount[next]++;
			
			if(menuList.contains(c)==false) //쿠폰메뉴가 고른리스트에 없으면 종류에 추가할 수 있고, 
				answer=Math.max(answer, menuList.size()+1);
			else
				answer=Math.max(answer, menuList.size()); //쿠폰메뉴가 고른 리스트에 이미 있으면 종류에 추가할 수 없음. 
			
		}
		System.out.println(answer);
	}
}
