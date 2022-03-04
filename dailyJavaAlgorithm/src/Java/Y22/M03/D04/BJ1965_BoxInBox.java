package Java.Y22.M03.D04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1965_BoxInBox {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 0;
		}
		
		int answer = 0;
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < i; j++) {
				if(arr[i] <= arr[j]) continue;
				if(dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
			
			if(dp[i] > answer) answer = dp[i];
		}
		
		System.out.println(answer + 1);
		
	}

}
