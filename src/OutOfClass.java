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
import java.util.HashSet;
import java.util.StringTokenizer;


public class OutOfClass {
	
	static Kattio io;
	static {
    	//System.out.println("in Try 1");
    	
            try {
				//io = new Kattio("breedflip");
		        io = new Kattio("problemname");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("in Try");
         
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = io.nextInt();
		ArrayList<Integer> input = new ArrayList<Integer> ();
		ArrayList<Integer> sorted = new ArrayList<Integer> ();
		
		for (int i = 0; i < n; i++) {
			int temp = io.nextInt();
			input.add(temp);
			sorted.add(temp);
		}
		
		Collections.sort(sorted);
		int cur = -1;
		
		for (int j = 0; j < n; j++) {
			if (input.get(j) != sorted.get(j)) {
				cur = j;
				break;
			}
		}
		
		if (cur == -1) {
			io.println(0);
			io.close();
			return;
		}
		int j = -1;
		
		for (int k = cur + 1; k < n; k++) {
			if (input.get(k) == sorted.get(cur)) {
				j = k;
				break;
			}
		}
		
		HashSet<Integer> hs = new HashSet<Integer> ();
		
		for (int m = cur; m < j; m++) {
			if (input.get(m) != sorted.get(cur)) {
				hs.add(input.get(m));
			}
		}
		
		io.println(hs.size());
		io.close();
	}

}
