package Java.Y22.M03.D07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11055_BiggestIncreaseSequence {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[N];
		for(int i = 0; i < N; i++) {
			int tmp = 0;
			for(int j = 0; j < i; j++) {
				if(arr[j] >= arr[i]) continue;
				
				tmp = Integer.max(tmp, dp[j]);
				
			}
			dp[i] = tmp + arr[i];
		}
		
		int answer = 0;
		for(int i = 0; i < N; i++) {
			answer  = Integer.max(answer, dp[i]);
		}
		System.out.println(answer);
		
	}

}
