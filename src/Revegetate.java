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


public class Revegetate {
	
	static Kattio io;
	static {
    	//System.out.println("in Try 1");
    	
            try {
				io = new Kattio("revegetate");
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
		int m = io.nextInt();
		
		HashMap<Integer, ArrayList<Integer>> network = new HashMap<Integer, ArrayList<Integer>> ();
		
		HashMap<Integer, HashSet<Integer>> colors = new HashMap<Integer, HashSet<Integer>> ();
		HashMap<Integer, Integer> finalColor = new HashMap<Integer, Integer> ();
		
		for (int i = 1; i <= n; i++) {
			HashSet<Integer> temp = new HashSet<Integer> ();
			ArrayList<Integer> temp1 = new ArrayList<Integer> ();
			colors.putIfAbsent(i, temp);
			network.putIfAbsent(i, temp1);
		}
		
		
		for (int i = 0; i < m; i++) {
			int index = io.nextInt();
			int input = io.nextInt();
			
			
			
			if (network.containsKey(index)) {
				
				network.get(index).add(input);
			}
			
			else {
				ArrayList<Integer> temp = new ArrayList<Integer> ();
				
				temp.add(input);
				network.put(index, temp);
			}
			
			
			if (network.containsKey(input)) {
				
				network.get(input).add(index);
			}
			
			else {
				ArrayList<Integer> temp = new ArrayList<Integer> ();
				
				temp.add(index);
				network.put(input, temp);
			}
			
		}
		
		
		for (int i = 1; i <= n; i++) {
			
			
			
			
			for (int k = 1; k <= 4; k++) {
				
				
				
				//System.out.print("  ");
				if (!colors.get(i).contains(k)) {
					
					finalColor.put(i, k);
					for (int p = 0; p < network.get(i).size(); p++) {
						
					
						
						//System.out.print(network.get(i).get(p) + "-");
						//System.out.print(k+ " ");
						
						
						colors.get(network.get(i).get(p)).add(k);
						for( int strCurrentNumber : colors.get(network.get(i).get(p)) ){
				          //  System.out.print( strCurrentNumber );
				        }
						for( int strCurrentNumber : colors.get(3) ){
				           // System.out.print( strCurrentNumber );
				        }
						
					}
					//System.out.println();
					
					break;
				}
				
			}
			
			
		}
		
		for (int i = 1; i <= n; i++) {
			io.print(finalColor.get(i));
		}
		io.println();
		io.close();
	}

}
