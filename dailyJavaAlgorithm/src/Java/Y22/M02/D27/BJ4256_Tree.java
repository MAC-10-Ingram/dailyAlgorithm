package Java.Y22.M02.D27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ4256_Tree {
	
	public static String toLRP(String[] PLR, String[] LPR) {
		
		if(PLR.length == 1) return PLR[0];
		
		String P = ""+PLR[0];
		
		
		int ip = 0;
		
		for(int i = 0; i < LPR.length; i++) {
			if(P.equals(LPR[i])) {
				ip = i;
				break;
			}
		}
		
		
		String[] lprL = Arrays.copyOfRange(LPR, 0, ip);// LPR.substring(0, ip).trim();
		String[] lprR = Arrays.copyOfRange(LPR, ip + 1, LPR.length);// LPR.substring(ip + 1).trim();
		
		int llen = lprL.length;
		String[] plrL = Arrays.copyOfRange(PLR, 1, 1 + llen);// PLR.substring(1, 2 + lprL.length()).trim();
		String[] plrR = Arrays.copyOfRange(PLR, 1 + llen, PLR.length);// PLR.substring(2 + lprL.length()).trim();
		
		String result = "";
		
		if(plrL.length > 0) result += (toLRP(plrL, lprL)) + " ";
		if(plrR.length > 0) result += (toLRP(plrR, lprR)) + " ";
		
		result += P;
		return result;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			String PLR = br.readLine();
			String LPR = br.readLine();
			sb.append(toLRP(PLR.split(" "), LPR.split(" ")));
			sb.append('\n');
		}
		System.out.println(sb);
	}

}
