import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BreedFlip {
	
	static Kattio io;
	static {
    	//System.out.println("in Try 1");
    	
            try {
				io = new Kattio("breedflip");
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
		
		String input = io.next();
		String output = io.next();
		
		int c = 0;
		int flip = 0;
		
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) != output.charAt(i)) {
				if (flip == 0) {
					flip = 1;
					c++;
				}
				
				continue;
			}
			else {
				if (flip == 1) {
					
					flip = 0;
				}
			}
		}
		
		io.println(c);
		io.close();
	}

}
