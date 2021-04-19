import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Herding {
	
	static Kattio io;
	static {
    	//System.out.println("in Try 1");
    	
            try {
				io = new Kattio("herding");
		        //io = new Kattio("problemname");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("in Try");
         
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> x = new ArrayList<Integer> ();
		int a = io.nextInt();
		int b = io.nextInt();
		int c = io.nextInt();
		
		x.add(a);
		x.add(b);
		x.add(c);
		
		Collections.sort(x);
		
		int one = x.get(0);
		int two = x.get(1);
		int three = x.get(2);
		
		int diff1 = two - one;
		int diff2 = three - two;
		
		int minDiff = Math.min(diff2, diff1);
		int maxDiff = Math.max(diff2, diff1);
		
		if (maxDiff == 1) {
			io.println(0);
			io.println(0);
			io.close();
			return;
		}
		
		if (maxDiff == 2) {
			io.println(1);
			io.println(1);
			io.close();
			return;
		}
		
		if (minDiff == 2) {
			io.println(1);
			io.println(maxDiff - 1);
			io.close();
			return;
		}
		else {
			io.println(2);
			io.println(maxDiff - 1);
			io.close();
			return;
		}
		//io.close();
		
	}

}
