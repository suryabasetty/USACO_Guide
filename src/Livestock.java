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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;


public class Livestock {
	
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
		String cowName;
		TreeSet<String> cows;
	}
	
	static HashMap<String, ArrayList<String>> network = new HashMap<String, ArrayList<String>> ();
	static HashMap<String, Boolean> visited = new HashMap <String, Boolean> ();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//Bessie, Buttercup, Belinda, Beatrice, Bella, Blue, Betsy, and Sue.
		network.putIfAbsent("Bessie", null);
		network.putIfAbsent("Buttercup", null);
		network.putIfAbsent("Belinda", null);
		network.putIfAbsent("Beatrice", null);
		network.putIfAbsent("Bella", null);
		network.putIfAbsent("Blue", null);
		network.putIfAbsent("Betsy", null);
		network.putIfAbsent("Sue", null);
		
		visited.putIfAbsent("Bessie", false);
		visited.putIfAbsent("Buttercup", false);
		visited.putIfAbsent("Belinda", false);
		visited.putIfAbsent("Beatrice", false);
		visited.putIfAbsent("Bella", false);
		visited.putIfAbsent("Blue", false);
		visited.putIfAbsent("Betsy", false);
		visited.putIfAbsent("Sue", false);
		int n = io.nextInt();
		
		for (int i = 0; i < n; i++) {
			String cow1 = io.next();
			io.next(); io.next(); io.next(); io.next();
			String cow2 = io.next();
			
			if (network.get(cow1) == null) {
				
				ArrayList<String> temp = new ArrayList<String> ();
				network.put(cow1, temp);
				
				
			}
			if (network.get(cow2) == null) {
				
				ArrayList<String> temp = new ArrayList<String> ();
				network.put(cow2, temp);
				
				
			}
			
			network.get(cow1).add(cow2);
			network.get(cow2).add(cow1);
		}
		
		
		compute();
	
		io.close();
	
	}
	
	public static void compute() {
		String temp = getLeast();
		
		if (temp == null) {
			return;
		}
		visited.put(temp, true);
		HashSet<String> current = new HashSet<String> ();
		current.add(temp);
		form(temp, current);
		compute();
	}
	
	public static void form (String temp, HashSet<String> current) {
		
		io.println(temp);
		if (network.get(temp) == null) {
			return;
		}
		
		for (int i = 0; i < network.get(temp).size(); i++) {
			if (!current.contains(network.get(temp).get(i))) {
				current.add(network.get(temp).get(i));
				visited.put(network.get(temp).get(i) , true);
				form (network.get(temp).get(i), current);
				break;
			}
		}
		
		return;
		
	}
	
	public static String getLeast () {
		
		ArrayList<String> cows = new ArrayList<String> ();
		for (String cow : visited.keySet()) {
			if ((!(visited.get(cow)) && ((network.get(cow) == null) || (network.get(cow).size() == 1)))){
				cows.add(cow);
			}
		}
		Collections.sort(cows);
		if (cows.size() == 0) {
			return null;
		}
		else 
		{
			return cows.get(0);
		}
		
	}
}
