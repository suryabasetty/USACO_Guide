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



public class Sleepy {
	
	static Kattio io;
	static {
    	//System.out.println("in Try 1");
    	
            try {
				//io = new Kattio("taming");
		        io = new Kattio("problemname");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("in Try");
         
    }
	static ArrayList<Integer> allList = new ArrayList<Integer> ();
	static ArrayList<Integer> allListSorted = new ArrayList<Integer> ();
	static ArrayList<Integer> iterativeSortedList = new ArrayList<Integer> ();
	static int totalSteps = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int total = io.nextInt();
		for (int i = 0; i < total; i++) {
			int temp = io.nextInt();
			allList.add(temp);
			allListSorted.add(temp);
			
		}
		
		Collections.sort(allListSorted);
		System.out.println(allList);
		System.out.println(allListSorted);
		
		
		int counter = total - 1;
		while (counter >=0) {
			int temp = allListSorted.get(counter);
			checkCounter(temp);
			counter--;
		}
		io.println(totalSteps);
		io.close();
	}
	
	public static void checkCounter(int current) {
		int c = 0;
		
		if (present (current)) {
			return;
		}
		
		if (allList.size() == 1) {
			//totalSteps++;
			return;
		}
		
		while (true) {
			if (allList.get(0) != current) {
				iterativeSortedList.add(allList.get(0));
				allList.remove(0);
				c++;
				continue;
			}
			else {
			totalSteps += c;
			//iterativeSortedList.add(allList.get(0));
			allList.remove(0);
			totalSteps++;
			break;
			}
		}
	}
	
	public static boolean present (int current) {
		for (int i = 0; i < iterativeSortedList.size(); i++) {
			if (iterativeSortedList.get(i) == current) {
				return true;
			}
		}
		return false;
	}
	
	public static void addElement (int n) {
		int c = 0;
		if (iterativeSortedList.size() == 0) {
			iterativeSortedList.add(n);
		}
		
		while (iterativeSortedList.get(c) < n) {
			c++;
		}
		
		iterativeSortedList.add(c, n);
	}

}
