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



public class Cownomics {
	
	static Kattio io;
	static {
    	//System.out.println("in Try 1");
    	
            try {
				io = new Kattio("cownomics");
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
		
		ArrayList<String> spotty = new ArrayList<String> ();
		ArrayList<String> nonspotty = new ArrayList<String> ();
		
		for (int i = 0; i < n; i++) {
			spotty.add(io.next());
		}
		
		for (int i = 0; i < n; i++) {
			nonspotty.add(io.next());
		}
		int total = 0;
		for (int i = 0; i < m; i++) {
			ArrayList<Character> combs = new ArrayList<Character> ();
			for (int j = 0; j < n; j++) {
				combs.add(spotty.get(j).charAt(i));
			}
			
			int flag = 0;
			for (int j = 0; j < n; j++) {
				char nonSpottyChar = nonspotty.get(j).charAt(i);
				for (int s = 0; s < combs.size(); s++) {
					if (combs.get(s) == nonSpottyChar) {
						flag = 1;
						break;
					}
				}
			}
			
			if (flag == 0) {
				total++;
			}
			
		}
		
		io.println(total);
		io.close();
	}

}
