package Java.Y22.M03.D13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1535_hi {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int L[] = new int[N + 1];
		int J[] = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++){
			L[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++){
			J[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[N + 1][100];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j < 100; j++ ) {
				dp[i][j] = Integer.max(dp[i - 1][j],dp[i][j - 1]);
				if(j > L[i]) dp[i][j] = Integer.max(dp[i][j], dp[i - 1][j - L[i]] + J[i]);
			}
		}
		
		System.out.println(dp[N][99]);
	}

}
