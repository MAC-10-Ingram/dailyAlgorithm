package Java.Y22.M02.D27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Subject implements Comparable<Subject>{
	int exd;
	int score;
	
	public Subject(int exd, int score) {
		this.exd = exd;
		this.score = score;
	}

	@Override
	public int compareTo(Subject o) {
		// TODO Auto-generated method stub
		return exd - o.exd;
	}

	@Override
	public String toString() {
		return "Subject [exd=" + exd + ", score=" + score + "]";
	}
	
	
}

public class BJ13904_Subject {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N  = Integer.parseInt(br.readLine());
		
		PriorityQueue<Subject> pq = new PriorityQueue<>();
		PriorityQueue<Integer> pq2 = new PriorityQueue<>();
		int answer = 0;
		while(N-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pq.add(new Subject(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		while(!pq.isEmpty()) {
			Subject cur = pq.poll();
			if(cur.exd > pq2.size()) {
				pq2.add(cur.score);
			}else {
				if(pq2.peek() < cur.score) {
					pq2.poll();
					pq2.add(cur.score);
				}
				
			}
		}
		
		
		for(Integer i : pq2) {
			answer += i;
		}
		
		System.out.println(answer);
	}

}
