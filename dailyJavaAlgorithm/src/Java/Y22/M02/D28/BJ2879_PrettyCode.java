package Java.Y22.M02.D28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2879_PrettyCode {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		int N  = Integer.parseInt(br.readLine());
		
		
		int answer = 0;
		int[] array = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			array[i] -= Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			array[i] += Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = N - 1;
		
		while(left <= right) {
			
			//System.out.println(left+":"+right+" "+Arrays.toString(array));
			int ll = left;
			int rr = right;
			
			
			while(ll <= rr && array[ll] * array[rr] <= 0) {
				ll++;
			}
			
			if(ll > rr) break;
			
			int indent = 0;
			if(Math.abs(array[ll]) > Math.abs(array[rr])) {
				indent = array[rr];
			}else {
				indent = array[ll];
			}
			
			answer += Math.abs(indent);
			
			while(ll <= rr) {
				array[ll] -= indent;
				ll++;
			}
			
			while(left < N && array[left] == 0) {
				left++;
			}
			
			while(right > -1 && array[right] == 0) {
				right--;
			}
			
		}
		
		System.out.println(answer);
	}

}
