import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;




public class Hoofball {

	static Kattio io;
	static {
    	//System.out.println("in Try 1");
    	
            try {
				io = new Kattio("hoofball");
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
		ArrayList<Integer> dirChange = new ArrayList<Integer> ();
		ArrayList<Integer> input = new ArrayList<Integer> ();
		for (int i = 0; i < n; i++) {
			input.add(io.nextInt());
		}
		
		dirChange.add(1);
		Collections.sort(input);
		for (int i = 1; i < n-1; i++) {
			if (input.get(i) - input.get(i-1) <=  input.get(i+1) - input.get(i)) {
				dirChange.add(0);
			}
			else {
				dirChange.add(1);
			}
		}
		dirChange.add(0);
		ArrayList<Integer> output = new ArrayList<Integer> ();
		
		int c = 1;
		//System.out.println(dirChange);
		for (int i = 1; i < n;i++) {
			if (dirChange.get(i-1) != dirChange.get(i)) {
				output.add(c);
				c = 1;
				
				
			}
			else {c++;}
		}
		output.add(c);
		int total = 0;
	int flag = 0;
	int sum = 0;
	  for (int i = 0; i < output.size(); i++) {
		  sum += output.get(i);
	  }
	//System.out.println(input);
	System.out.println(output);
	  while (output.size() >= 1) {
		  if (output.size() == 1) {
			  total += 1;
			  break;
			  
		  }
		  
		  if (output.get(0) == 0) {
			  output.remove(0);
		  }
		  
		  if ((output.get(0) == 1) || (output.get(1) == 1)) {
				
			  if (flag == 0) {
				    total += 1;
					output.remove(0);
					output.remove(0);
				} 
			  else {
				  total += 1;
				  output.remove(0);
				  flag = 0;
			  }
			
		  }
		  
			  
			  	
		  else {
			  
			  if (flag == 0) {
				  output.remove(0);
				  total += 1;
				  int temp = output.get(0);
				  
				  output.set(0, temp -1);
				  flag = 1;
			  }
			  else {
				  output.remove(0);
				  total += 1;
				  flag = 0;
			  }
		  }
	  }
	  
		//System.out.println(sum);
		//io.println((output.size()+1)/2);
		io.println(total);
		io.close();
		
	}

}
