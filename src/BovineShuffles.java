import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;



public class BovineShuffles {
	
	static Kattio io;
    static {
    	//System.out.println("in Try 1");
    	
            try {
				io = new Kattio("shuffle");
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
		List<ArrayList<Integer>> mapping = new ArrayList<ArrayList<Integer>> ();
		
		for (int i = 0; i < n; i ++) {
			List<Integer> input = new ArrayList<Integer> ();
			input.add(i+1);
			input.add(io.nextInt());
			mapping.add((ArrayList<Integer>) input);
		}
		
		List<String> finalOrder = new ArrayList<String>();
		finalOrder.add("empty");
		for (int i = 0; i < n ; i ++) {
			finalOrder.add(io.next());
		}
		
		int[] order = new int[n + 1];
		for (int i = 0; i < n+1; i ++) {
			order [i] = i;
		}
		
		int[] temp = new int[n + 1];
		for (int i = 0; i < n+1; i ++) {
			temp [i] = order[i];
		}
		
		//System.out.println(temp[0] + " " + temp[1] + " " + temp[2] + " "+temp[3] + " " +temp[4]+" "+temp[5]);
		for (int i = 0; i < n; i ++) {
			//System.out.println(mapping.get(i).get(0) + " " + mapping.get(i).get(1));
			temp[mapping.get(i).get(1)] = order[mapping.get(i).get(0)];
			//System.out.println(order[mapping.get(i).get(1)]);
			//System.out.println(order[0] + " " + order[1] + " " + order[2] + " "+order[3] + " " +order[4]+" "+order[5]);
		}
		//System.out.println(mapping);
		//System.out.println(temp[0] + " " + temp[1] + " " + temp[2] + " "+temp[3] + " " +temp[4]+" "+temp[5]);
		for (int i = 0; i < n+1; i ++) {
			order [i] = temp[i];
		}
		//System.out.println(temp[0] + " " + temp[1] + " " + temp[2] + " "+temp[3] + " " +temp[4]+" "+temp[5]);
		for (int i = 0; i < n; i ++) {
			temp[mapping.get(i).get(1)] = order[mapping.get(i).get(0)];
		}
		//System.out.println(temp[0] + " " + temp[1] + " " + temp[2] + " "+temp[3] + " " +temp[4]+" "+temp[5]);
		for (int i = 0; i < n+1; i ++) {
			order [i] = temp[i];
		}
		
		for (int i = 0; i < n; i ++) {
			temp[mapping.get(i).get(1)] = order[mapping.get(i).get(0)];
		}
		
		//System.out.println(temp[0] + " " + temp[1] + " " + temp[2] + " "+temp[3] + " " +temp[4]+" "+temp[5]);
		for (int cur = 1; cur <=n; cur++) {
			for (int i = 1; i <= n; i ++) {
				if (temp[i] == cur) 	{
				
					io.println(finalOrder.get(i));
				}
			}
		}
		io.close();
		
		
	}

}
