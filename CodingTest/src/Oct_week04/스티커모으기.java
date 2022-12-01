package CodingTest.src.Oct_week04;

public class 스티커모으기 {
	int dp[];
	int dp2[];

	public int solution(int sticker[]) {
		int answer = 0;
		int n = sticker.length;

		// 원형 스티커를 1차원 배열로 생각
		// dp[i] : 0번째부터 i번째 까지 스티커를 고려하였을 때 가능한 최댓값 저장
		dp = new int[n]; // 맨처음 스티커 포함 o 했을 때의 dp 배열
		dp2 = new int[n]; // 맨처음 스티커 포함 x 했을 때의 dp 배열

		if (n == 1)
			return answer = sticker[0];

		// 맨 처음 스티커 포함한 경우
		dp[0] = sticker[0];
		dp[1] = Math.max(dp[0], sticker[1]);

		for (int i = 2; i < n; i++) { // 마지막 스티커는 포함할수 없으므로 i<n-1 까지 반복
			if (i == n - 1) {
				dp[i] = dp[i - 1];
				continue;
			}
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[i]);

		}
		// 맨 처음 스티커 포함하지 않은 경우
		dp2[0] = 0;
		dp2[1] = sticker[1];
		for (int i = 2; i < n; i++) {
			dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);

		}

		return answer = Math.max(dp[n - 1], dp2[n - 1]);
	}
}
