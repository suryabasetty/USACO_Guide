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
import java.util.HashSet;
import java.util.StringTokenizer;

class Kattio extends PrintWriter {
    private BufferedReader r;
    private StringTokenizer st = new StringTokenizer("");
    private String token;

    // standard input
    public Kattio() { this(System.in,System.out); }
    public Kattio(InputStream i, OutputStream o) {
        super(o);
        r = new BufferedReader(new InputStreamReader(i));
    }
    // USACO-style file input
    public Kattio(String problemName) throws IOException { 
       //super(new FileWriter("/Users/krishnabasetty/newbegining/USACO_Guide/src/" + problemName+".out"));
       super(new FileWriter(problemName+".out"));
       //r = new BufferedReader(new FileReader("/Users/krishnabasetty/newbegining/USACO_Guide/src/" + problemName+".in"));
       r = new BufferedReader(new FileReader(problemName+".in"));
    }

    private String peek() {
        if (token == null)
            try {
                while (!st.hasMoreTokens()) {
                    String line = r.readLine();
                    // System.out.println("debug" + line);
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) { }
        return token;
    }
    public boolean hasMoreTokens() { return peek() != null; }
    public String next() {
        String ans = peek(); 
        token = null;
        return ans;
    }
    
    public int nextInt() { return Integer.parseInt(next()); }
    public double nextDouble() { return Double.parseDouble(next()); }
    public long nextLong() { return Long.parseLong(next()); }
}


public class Swap {
	

	static Kattio io;
	static {
    	//System.out.println("in Try 1");
    	
            try {
				io = new Kattio("lineup");
		        //io = new Kattio("problemname");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("in Try");
         
    }
	
	static class Cow {
		int cow;
		ArrayList<Integer> position = new ArrayList<Integer> ();
	}
	static HashMap<Integer, ArrayList<Integer>> allCows = new HashMap<Integer, ArrayList<Integer>> ();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = io.nextInt();
		int k = io.nextInt();
		int[] currentPosition = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			
			currentPosition[i] = i;
		}
		
		int firstStart = io.nextInt();
		int firstEnd = io.nextInt();
		int secondStart = io.nextInt();
		int secondEnd = io.nextInt();
		int firstDiff = firstEnd-firstStart;
		int secondDiff = secondEnd - secondStart;
		
		for (int l = 0; l < (firstDiff)/2; l++) {
			int temp = currentPosition[firstStart+l];
			
			currentPosition[l] = currentPosition[firstEnd- l];
			currentPosition[firstEnd - l] = temp;
		}
		
		for (int l = 0; l < (secondDiff)/2; l++) {
			int temp = currentPosition[secondStart+l];
			
			currentPosition[l] = currentPosition[secondEnd- l];
			currentPosition[secondEnd - l] = temp;
		}
		
		for (int i = 1; i <= n; i++) {
			ArrayList<Integer> temp = new ArrayList<Integer> ();
			temp.add(i);
			allCows.put(currentPosition[i], temp);
			
		}
		
		for (int i = 1; i <= n; i++) {
			int[] visited = new int[n+ 1];
			io.println(compute(i, k, visited, 0));
		}
		
	}
	
	public static int compute (int i, int k, int[] visited, int current) {
	
		
		if (current < k) {
			
		}
		return 0;
	}
}
