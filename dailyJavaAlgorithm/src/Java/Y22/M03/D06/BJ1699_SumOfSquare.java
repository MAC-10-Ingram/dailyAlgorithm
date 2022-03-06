package Java.Y22.M03.D06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ1699_SumOfSquare {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			dp[i] = i;
			
			for(int j = 1; i - (j * j) >= 0; j++) {
				if(dp[i] > dp[i - (j * j)] + 1) dp[i] = dp[i - j * j] + 1;
				
			}
		}
		System.out.println(dp[N]);
	}

}
