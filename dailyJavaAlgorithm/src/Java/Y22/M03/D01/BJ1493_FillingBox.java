package Java.Y22.M03.D01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Point{
	int w, h, l;
	
	public Point(int w, int h, int l) {
		this.w = w;
		this.h = h;
		this.l = l;
	}
	
	public Point(Point p) {
		this.w = p.w;
		this.h = p.h;
		this.l = p.l;
	}
}

class Box{
	Point start;
	Point end;
	
	public Box(Point start, Point end) {
		this.start = start;
		this.end = end;
	}
	
	public int getLength() {
		return end.l - start.l;
	}
	
	public int getHeight() {
		return end.h - start.h;
	}
	
	public int getWidth() {
		return end.w - start.w;
	}
	
	public Box getSubBox(int len, Point vector) {
		Point s = new Point(start);
		Point e = new Point(end);
		
		if(vector.l == 1) {
			s.l += len;
		}else {
			e.l = s.l + len;
		}
		
		if(vector.h == 1) {
			s.h += len;
		}else {
			e.h = s.h + len;
		}
		
		if(vector.w == 1) {
			s.w += len;
		}else {
			e.w = s.w + len;
		}
		
		return new Box(s, e);
	}
}

public class BJ1493_FillingBox {
	static int W, H, L;
	static int[] boxes;
	static Point[] vectors;
	static int[] dw = {0,0,1,0,1,1,1};
	static int[] dh = {0,1,0,1,0,1,1};
	static int[] dl = {1,0,0,1,1,0,1};
	
	static int recur(Box box) {
		//System.out.println(box);
		int i = 19;
		int len = 1 << 19;
		int answer = 0;
		
		
		for(; i > -1; i--, len >>= 1) {
			if(boxes[i] < 1) continue;
			
			//System.out.println(i+" "+len);
			if(len <= box.getLength() && len <= box.getWidth() && len <= box.getHeight()) {
				answer++;
				boxes[i]--;
				break;
			}
		}
		
		if(answer == 0) return -1;
		
		for(int d = 0; d < 7; d++) {
			Box next = box.getSubBox(len, vectors[d]);
			if(next.getHeight() == 0) continue;
			if(next.getLength() == 0) continue;
			if(next.getWidth() == 0) continue;
			
			int result = recur(next);
			if(result < 0) {
				answer = -1;
				break;
			}
			
			answer += result;
		}
		
		return answer;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		vectors = new Point[7];
		for(int d = 0; d < 7; d++) {
			vectors[d] = new Point(dw[d],dh[d],dl[d]);
		}
		
		int N = Integer.parseInt(br.readLine());
		
		boxes = new int[20];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());
			boxes[index] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(recur(new Box(new Point(0,0,0), new Point(W, H, L))));
	}

}