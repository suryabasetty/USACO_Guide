import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Pails {

	static Kattio io;
	static {
    	//System.out.println("in Try 1");
    	
            try {
				io = new Kattio("pails");
		        //io = new Kattio("problemname");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("in Try");
         
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int glass1 = io.nextInt();
		int glass2 = io.nextInt();
		int total = io.nextInt();
		
		int iterateMax1 = total/glass1;
		int iterateMax2 = total/glass2;
		int max = 0;
		
		for (int i = 0; i <= iterateMax1; i++) {
			for (int j = 0; j <= iterateMax2; j++) {
				int multiply = i*glass1 + j*glass2;
				max = ((max < multiply) && (multiply <= total)) ? multiply : max;
			}
		}
		
		io.println(max);
		io.close();

	}

}
