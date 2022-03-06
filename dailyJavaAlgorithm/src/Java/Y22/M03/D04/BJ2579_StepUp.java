package Java.Y22.M03.D04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2579_StepUp {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] step = new int[N + 1];
		int[][] dp = new int[N + 1][2];
		for(int i = 1; i < N + 1; i++) {
			step[i] = Integer.parseInt(br.readLine());
		}
		
		int[][] next = new int[2][];
		next[0] = new int[]{0,1};
		next[1] = new int[]{0};
		
		int[] gap = {2, 1};
		
		dp[1][1] = step[1];
		
		if(N == 1) {
			System.out.println(step[1]);
			return;
		}
		
		dp[2][1] = dp[1][1] + step[2];
		dp[2][0] = step[2];
		
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < 2; j++) {
				for(int nj : next[j]) {
					if(i + gap[nj] > N) continue;
					
					if(dp[i + gap[nj]][nj] < dp[i][j] + step[i + gap[nj]]) {
						dp[i + gap[nj]][nj] = dp[i][j] + step[i + gap[nj]];
					}
				}
			}
		}
		
		System.out.println(Integer.max(dp[N][0], dp[N][1]));
		
	}

}
