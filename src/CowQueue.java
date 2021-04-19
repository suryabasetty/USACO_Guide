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


public class CowQueue {
	
	static class CowWait {
		int arrivalTime;
		int questionTime;
	}
	
	static Kattio io;
	static {
    	//System.out.println("in Try 1");
    	
            try {
				io = new Kattio("cowqueue");
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
		
		List<CowWait> schedule = new ArrayList<CowWait> ();
		for (int i = 0; i < total; i++) {
			CowWait newCow = new CowWait();
			newCow.arrivalTime = io.nextInt();
			newCow.questionTime = io.nextInt();
			schedule.add(newCow);
		}
		
		schedule.sort((l1, l2) -> Integer.compare(l1.arrivalTime, l2.arrivalTime));
		int nextCowEntry = 0;
		
		for (int i = 0; i < schedule.size(); i++) {
			if (nextCowEntry < schedule.get(i).arrivalTime) {
				nextCowEntry = schedule.get(i).arrivalTime;
			}
			
			nextCowEntry = schedule.get(i).questionTime + nextCowEntry;
		}
		
		io.println(nextCowEntry);
		io.close();
	}

}
