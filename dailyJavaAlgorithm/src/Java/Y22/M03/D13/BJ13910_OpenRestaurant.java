package Java.Y22.M03.D13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ13910_OpenRestaurant {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		final int INF = 987654321;
		ArrayList<Integer> cap = new ArrayList<>();
		
		int[] woks = new int[M];
		int[] dp = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			dp[i] = INF;
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			woks[i] = Integer.parseInt(st.nextToken());
			if(woks[i]<= N) cap.add(woks[i]);
		}
		
		for(int i = 0; i < M; i++) {
			for(int j = i + 1; j < M; j++) {
				if(woks[i] + woks[j] > N) continue;
				cap.add(woks[i] + woks[j]);
			}
		}
		
		Collections.sort(cap);
		
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < cap.size(); j++) {
				int cur = cap.get(j);
				if(cur > i) break;
				
				if(cur == i) {
					dp[i] = 1;
					break;
				}
				
				if(i < cur) break;
				dp[i] = Integer.min(dp[i], 1 + dp[i - cur]);
				
			}
		}
		
		if(dp[N] == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(dp[N]);
	}

}
