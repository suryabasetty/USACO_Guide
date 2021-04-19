import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Race {
	
	static Kattio io;
	static {
    	//System.out.println("in Try 1");
    	
            try {
				io = new Kattio("race");
		        //io = new Kattio("problemname");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("in Try");
         
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long k = io.nextLong();
		long n = io.nextLong();
		
		for (int i = 0; i < n; i++) {
			long cur = io.nextLong();
			calculate (k , cur);
		}
		io.close();
	}
	
	public static void calculate (long k , long cur) {
		
		long time  = 0;
		long dist = 0;
		while (time < cur) {
			time++;
			dist = dist+time;
			if (dist >= k) {
				io.println(time);
				return;
			}
		}
		
		long rem = k - dist;
		
		long totalTime = time;
		long curTime = time;
		
		while (rem > 0) {
			
			if (rem <= curTime) {
				//curTime++;
				io.println(totalTime + 1);
				return;
			}
			
			if (rem<=(2*curTime + 1)) {
				
				io.println(totalTime + 2);
				return;
			}
			
			rem = (rem - 2*(curTime)) - 1;
			curTime++;
			totalTime += 2;
		}
		
		
		
		
	}
}
