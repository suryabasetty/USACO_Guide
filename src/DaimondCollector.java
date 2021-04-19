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

public class DaimondCollector {
	static Kattio io;
	static {
    	//System.out.println("in Try 1");
    	
            try {
				io = new Kattio("diamond");
		        //io = new Kattio("problemname");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("in Try");
         
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int total = io.nextInt();
		int k = io.nextInt();
		
		ArrayList<Integer> allMilks = new ArrayList<Integer> ();
		
		for (int i = 0; i < total; i++) {
			allMilks.add(io.nextInt());
		}
		
		int answer = 0;
		for (int i = 0; i < total; i++) {
			int min = allMilks.get(i);
			int max = (allMilks.get(i) + k);
			int totalCount = 0;
			for (int j = 0; j < total; j++) {
				
				
					if ((allMilks.get(j) >= min) && (allMilks.get(j) <= max)) {
						//System.out.println(allMilks.get(j));
						totalCount++;
					}
				
			}
			//totalCount++;
			answer = answer > (totalCount) ? answer : totalCount;
		}
		
		io.println(answer);
		io.close();
	}

}
