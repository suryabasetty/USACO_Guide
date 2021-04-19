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
import java.util.TreeMap;



public class NotLast {
	
	static Kattio io;
	static {
    	//System.out.println("in Try 1");
    	
            try {
				io = new Kattio("whereami");
		        //io = new Kattio("problemname");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("in Try");
         
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeMap<String, Integer> tm = new TreeMap<String, Integer> ();
		tm.put("Bessie", 0);
		tm.put("Elsie", 0);
		tm.put("Daisy", 0);
		tm.put("Gertie", 0);
		tm.put("Annabelle", 0);
		tm.put("Maggie", 0);
		tm.put("Henrietta", 0);
		
		int n = io.nextInt();
		int c = 0;
		ArrayList<Integer> finalMilks = new ArrayList<Integer> ();
		
		for (int i = 0; i < n; i++) {
			String s = io.next();
			int milk = io.nextInt();
			
			if (!tm.containsKey(s)) {
				
				tm.put(s, c);
				finalMilks.set(c, milk);
				c++;
			}
			else {
				int index = tm.get(s);
				int curMilk = finalMilks.get(index) + milk;
				tm.put(s, curMilk);
				
			}
		}
		
		Collections.sort(finalMilks);
		
		int min = finalMilks.get(0);
		
		for (int i = 0; i < finalMilks.size(); i++) {
			if (finalMilks.get(i) > min) {
				
			}
		}
		
	}

}
