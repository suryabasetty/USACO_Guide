import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Planting {
	
	
	static Kattio io;
	static {
    	//System.out.println("in Try 1");
    	
            try {
				io = new Kattio("planting");
		        //io = new Kattio("problemname");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("in Try");
         
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<Integer, ArrayList<Integer>> hm = new HashMap<Integer, ArrayList<Integer>> ();
		
		int n = io.nextInt();
		
		for (int i = 0; i < n-1; i++) {
			int index = io.nextInt();
			int input = io.nextInt();
			if (hm.containsKey(index)) {
				
				hm.get(index).add(input);
			}
			
			else {
				ArrayList<Integer> temp = new ArrayList<Integer> ();
				
				temp.add(input);
				hm.put(index, temp);
			}
			
			
			if (hm.containsKey(input)) {
				
				hm.get(input).add(index);
			}
			
			else {
				ArrayList<Integer> temp = new ArrayList<Integer> ();
				
				temp.add(index);
				hm.put(input, temp);
			}
		}
		
		int max = 0;
		ArrayList<Integer> empty = new ArrayList<Integer> ();
		for (int i = 1; i <= n; i++ ) {
			int size = hm.getOrDefault(i, empty).size();
			max = max > size ? max : size;
			
		}
		
		io.println(max + 1);
		io.close();
	}

}
