import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class RestStops {
	
	static Kattio io;
	static {
    	//System.out.println("in Try 1");
    	
            try {
				//io = new Kattio("reststops");
		       io = new Kattio("problemname");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("in Try");
         
    }
	
	
	static class Point {
		long x;
		long taste;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long l = io.nextLong();
		long n = io.nextLong();
		long farmerSpeed = io.nextLong();
		long cowSpeed =io.nextLong();
		long diff = farmerSpeed - cowSpeed;
		ArrayList<Point> points = new ArrayList<Point> ();
		
		for (int i = 0; i < n; i++) {
			Point p = new Point ();
			
			p.x = io.nextLong();
			p.taste = io.nextLong();
			points.add(p);
		}
		
		int index = points.size() - 1;
		
		while (index > 0) {
			if (points.get(index).taste >= points.get(index - 1).taste) {
				points.remove(index - 1);
				index --;
				continue;
			}
			index--;
		}
		
		long curTime = 0;
		long tasteUnits = 0;
		
		for (int i = 0;i < points.size(); i++) {
			
			tasteUnits += (points.get(i).x - curTime)*points.get(i).taste*diff;
			curTime = points.get(i).x;
		}
		
		io.println(tasteUnits);
		io.close();
	}
	
	

}
