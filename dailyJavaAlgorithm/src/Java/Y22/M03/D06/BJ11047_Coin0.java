package Java.Y22.M03.D06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11047_Coin0 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] money = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			money[i] = Integer.parseInt(br.readLine());
		}
		int answer = 0;
		
		for(int i = N; i > 0; i--) {
			if(K < money[i]) continue;
			
			answer += K / money[i];
			K %= money[i];
		}
		
		System.out.println(answer);
	}

}
