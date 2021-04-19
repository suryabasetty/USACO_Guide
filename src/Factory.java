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

public class Factory {
	
	

	static Kattio io;
	static {
    	//System.out.println("in Try 1");
    	
            try {
				io = new Kattio("factory");
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
		
		HashMap<Integer, ArrayList<Integer>> network = new HashMap<Integer, ArrayList<Integer>> ();
		HashMap<Integer, HashSet<Integer>> connections = new HashMap<Integer, HashSet<Integer>> ();
		
		for (int i = 1; i <= n; i++) {
			ArrayList<Integer> temp = new ArrayList<Integer> ();
			network.putIfAbsent(i, temp);
			HashSet<Integer> set = new HashSet<Integer> ();
			connections.putIfAbsent(i, set);
		}
		
		for (int i = 1; i < n; i++) {
			int station1 = io.nextInt();
			int station2 = io.nextInt();
			
			network.get(station2).add(station1);
		}
		
		int max = 0;
		for (int i = 1; i <= n; i++) {
			int[] visited = new int[n+1];
			ArrayList<Integer> stack = new ArrayList<Integer> ();
			stack.add(i);
			int cur = bfsreach (network,n, visited, stack);
			if (cur == n) {
				max = i;
				break;
			}
		}
		
		if (max == 0) {
			io.println(-1);
		}
		else {
			io.println(max);
		}
		
		io.close();
		//System.out.println(bfsreach(network, n, visited, stack));
	}
	
	public static int bfsreach (HashMap<Integer, ArrayList<Integer>> network, int n, int[] visited, ArrayList<Integer> stack) {
		
		if (stack.size() == 0) {
			return 0;
		}
		int i = stack.get(0);
		if (visited[i] == 1) {
			stack.remove(0);
			return bfsreach(network, n, visited, stack);
		}
		visited[i] = 1;
		for (int l = 0; l < network.get(i).size(); l++) {
			stack.add(network.get(i).get(l));
		}
		
		return (1 + bfsreach(network, n, visited, stack));
		
		
		
	}

}
