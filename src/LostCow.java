import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;



public class LostCow {
	
	static Kattio io;
    static {
    	//System.out.println("in Try 1");
    	
            try {
				io = new Kattio("lostcow");
		        //io = new Kattio("problemname");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("in Try");
         
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = io.nextInt();
		int y = io.nextInt();
		int totalDistance = 0;
		
		int ndiff = y - x;
		int diff = (ndiff > 0) ? ndiff : -ndiff;
		int flag =0;
		
		int multiplier = 1;
		
		while (multiplier < diff) {
			totalDistance += 2*multiplier;
			multiplier *= 2;
			flag = (flag == 0) ? 1:0;
		}
		
		if (flag == 0) {
			if (ndiff > 0) {
				totalDistance += diff;
			}
			else {
				totalDistance = totalDistance + 2*multiplier + diff;
			}
		}
		
		if (flag == 1) {
			if (ndiff < 0) {
				totalDistance += diff;
			}
			else {
				totalDistance = totalDistance + 2*multiplier + diff;
			}
		}
		
		io.println(totalDistance);
		io.close();
		
	}

}
