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

public class Speeding {
	
	static Kattio io;
    static {
    	//System.out.println("in Try 1");
    	
            try {
				//io = new Kattio("speeding");
		        io = new Kattio("problemname");
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
		
		List<ArrayList<Integer>> speedLimits = new ArrayList<ArrayList<Integer>> ();
		List<ArrayList<Integer>> cowSpeeds = new ArrayList<ArrayList<Integer>> ();
		
		for (int i = 0; i < n; i ++) {
			List<Integer> segment = new ArrayList<Integer> ();
			segment.add(io.nextInt());
			segment.add(io.nextInt());
			speedLimits.add((ArrayList<Integer>) segment);
		}
		
		for (int i = 0; i < m; i ++) {
			List<Integer> segment = new ArrayList<Integer> ();
			segment.add(io.nextInt());
			segment.add(io.nextInt());
			cowSpeeds.add((ArrayList<Integer>) segment);
		}
		
		
		for (int i = 1; i < n; i ++) {
			 speedLimits.get(i).set(0, (speedLimits.get(i).get(0) + speedLimits.get(i - 1).get(0)));
		}
		
		for (int i = 1; i < m; i ++) {
			cowSpeeds.get(i).set(0, (cowSpeeds.get(i).get(0) + cowSpeeds.get(i - 1).get(0)));
		}
		
		//System.out.println(cowSpeeds + "   " + speedLimits);
		int maxDiff = 0;
		
		int j = 0;
		for (int i = 0; i < m; i ++) {
			while ((j < n) && (cowSpeeds.get(i).get(0) >= speedLimits.get(j).get(0))) {
				maxDiff = (cowSpeeds.get(i).get(1) - speedLimits.get(j).get(1)) > maxDiff ? (cowSpeeds.get(i).get(1) - speedLimits.get(j).get(1)) : maxDiff;
				j++;
			}
			
			if (j == n) {
				break;
			}
			
		}
		
		io.println(maxDiff);
		io.close();
	}
	

}
