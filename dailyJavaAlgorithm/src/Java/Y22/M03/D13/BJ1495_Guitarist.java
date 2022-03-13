package Java.Y22.M03.D13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1495_Guitarist {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] V = new int[N];
		st = new StringTokenizer(br.readLine());
		
		int[][] dp = new int[N + 1][M + 1];
		dp[0][S] = 1;
		for(int i = 1; i <= N; i++) {
			int vol = Integer.parseInt(st.nextToken());
			for(int j = 0; j <= M ; j++) {
				if(dp[i - 1][j] < i) continue;
				
				if(j - vol >= 0) dp[i][j - vol] = dp[i - 1][j] + 1;
				if(j + vol <= M) dp[i][j + vol] = dp[i - 1][j] + 1;
			}
		}
		
		for(int i = M; i >= 0; i--) {
			if(dp[N][i] > N) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);
	}

}
