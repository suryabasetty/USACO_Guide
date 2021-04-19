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

public class CircleCross {
	
	static Kattio io;
	static {
    	//System.out.println("in Try 1");
    	
            try {
				io = new Kattio("circlecross");
		        //io = new Kattio("problemname");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("in Try");
         
    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = io.next();
		
		int[] visited = new int[26];
		int intersections = 0;
		
		//System.out.println(Character.getNumericValue('A'));
		for (int i = 0; i < input.length(); i++) {
			char current = input.charAt(i);
			
			if (visited[Character.getNumericValue(current) - 10] == 1) {
				continue;
			}
			int secondOccurance = 0;
			for (int j = i + 1; j < input.length(); j++) {
				if (current == input.charAt(j)) {
					secondOccurance = j;
					break;
				}
			}
			
			int[] currentLoop = new int[26];
			for (int j = i + 1; j < secondOccurance; j++) {
				currentLoop[Character.getNumericValue(input.charAt(j)) - 10] ++;
			}
			
			
			for (int j = 0; j < 26; j++) {
				if (currentLoop[j] == 1) {
					intersections++;
				}
			}
			
			visited[Character.getNumericValue(current) - 10] = 1;
		}
		
		io.println(intersections/2);
		io.close();

	}

}
