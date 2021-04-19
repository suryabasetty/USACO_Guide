import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BackForth {
		
	static Kattio io;
	static {
    	//System.out.println("in Try 1");
    	
            try {
				io = new Kattio("backforth");
		        //io = new Kattio("problemname");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("in Try");
         
    }
	
	
	static HashSet<Integer> finalTotal = new HashSet<Integer> ();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> firstlist = new ArrayList<Integer> ();
		ArrayList<Integer> secondlist = new ArrayList<Integer> ();
		for (int i = 0; i < 10; i++) {
			firstlist.add(io.nextInt());
		}
		
		for (int i = 0; i < 10; i++) {
			secondlist.add(io.nextInt());
		}
		
		
		recursive (1, 1000, 1000, firstlist, secondlist);
		
		io.println(finalTotal.size());
		io.close();
		
	}
	
	public static void recursive (int day, int first, int second, ArrayList<Integer> firstlist, ArrayList<Integer> secondlist) {
		if (day == 5) {
			//System.out.println(first +" ");
			finalTotal.add(first);
			return;
		}
		
		if ((day % 2) == 1) {
			for (int i = 0; i < firstlist.size(); i++) {
				int temp = firstlist.get(i);
				first -= firstlist.get(i);
				second += firstlist.get(i);
				secondlist.add(firstlist.get(i));
				firstlist.remove(i);
				recursive ((day + 1), first, second, firstlist, secondlist);
				first += temp;
				second -= temp;
				firstlist.add(i, temp);
				secondlist.remove(secondlist.size()-1);
				
				
				
			}
		}
		else if ((day % 2) == 0) {
			
			for (int i = 0; i < secondlist.size(); i++) {
				int temp = secondlist.get(i);
				second -= secondlist.get(i);
				first += secondlist.get(i);
				firstlist.add(secondlist.get(i));
				secondlist.remove(i);
				recursive ((day + 1), first, second, firstlist, secondlist);
				first -= temp;
				second += temp;
				secondlist.add(i, temp);
				firstlist.remove(firstlist.size()-1);
				
			}
		} 
		
		
	}
}
