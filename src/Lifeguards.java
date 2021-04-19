import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;



public class Lifeguards {
	
	static Kattio io;
	static {
    	//System.out.println("in Try 1");
    	
            try {
				io = new Kattio("lifeguards");
		        //io = new Kattio("problemname");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("in Try");
         
    }
	
	static class LifeGuard {
		int start;
		int end;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = io.nextInt();
		
		ArrayList<LifeGuard> allGuards = new ArrayList<LifeGuard> ();
		
		for (int i = 0; i < n; i++) {
			
			LifeGuard lg = new LifeGuard();
			
			lg.start = io.nextInt();
			lg.end = io.nextInt();
			
			allGuards.add(lg);
		}
		
		int maxCover = 0;
		for (int i = 0; i < n; i++) {
			
			int total = 0;
			int[] currCover = new int[1001];
			for (int j = 0; j < n; j++) {
				
				if (i != j) {
					for (int k = allGuards.get(j).start; k < allGuards.get(j).end; k++) {
						currCover[k] = 1;
					}
				} 
			}
			
			for (int j = 0; j < 1001; j++) {
				total += currCover[j];
			}
			
			maxCover = maxCover > total ? maxCover : total;
		}
		
		io.println(maxCover);
		io.close();
	}

}
