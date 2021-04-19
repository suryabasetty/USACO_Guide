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
import java.util.List;
import java.util.StringTokenizer;


public class Angry {
	
static Kattio io;
	
    static {
    	//System.out.println("in Try 1");
    	
            try {
				io = new Kattio("angry");
		        //io = new Kattio("problemname");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("in Try");
         
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = io.nextInt();
		List<Integer> numberLine = new ArrayList<Integer> ();
		for (int i = 0; i < n; i++) {
			numberLine.add(io.nextInt());
		}
		
		Collections.sort(numberLine);
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < numberLine.size(); i++) {
			int cur = goRight(numberLine, i, 1) + goLeft(numberLine, i, 1);
			max = (cur > max) ? cur : max ;
		}
		
		io.println( max + 1);
		
		io.close();
	}
	
	public static int goRight(List<Integer> numberLine, int index, int radius) {
		
		if (index == (numberLine.size() - 1)) {
			return 0;
		}
		int maxNumber = numberLine.get(index) + radius;
		
		
		int i = index + 1;
		
		while ((i < numberLine.size()) && (maxNumber >= numberLine.get(i))) {
			i++;
		}
		
		if ( i == numberLine.size()) {
			return (i - index - 1);
		}
		
		i = i - 1;
		if (i == index) {
			return 0;
		}
		else {
			//System.out.println(index);
			return ((i - index) + goRight(numberLine, i, radius + 1));
		}
		
		
	}
	
	public static int goLeft(List<Integer> numberLine, int index, int radius) {
		//System.out.println(index);
		if (index == 0) {
			return 0;
		}
		int minNumber = numberLine.get(index) - radius;
		//System.out.println (minNumber);
		
		int i = index - 1;
		//System.out.println ("i = " + i);
		
		while ((i >= 0) && (minNumber <= numberLine.get(i))) {
			i--;
		}
		//System.out.println ("i = " + i);
		if ( i == -1) {
			return (index - i - 1);
		}
		i = i + 1;
		if (i == index) {
			return 0;
		}
		else {
			
			return ((index - i) + goLeft(numberLine, i, radius + 1));
		}
		
		
	}

}
