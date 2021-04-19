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


public class Gymnastics {
	
	static Kattio io;
	static {
    	//System.out.println("in Try 1");
    	
            try {
				io = new Kattio("gymnastics");
		        //io = new Kattio("problemname");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("in Try");
         
    }
	
	static class DayRanking {
		int day;
		int[] ranking;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int days = io.nextInt();
		int n = io.nextInt();
		
		ArrayList<DayRanking> allDays = new ArrayList<DayRanking> ();
		
		for (int i = 0; i < days; i++) {
			DayRanking dr = new DayRanking();
			dr.ranking = new int[n + 1];
			for (int j = 1; j <= n; j++) {
				dr.ranking[io.nextInt()] = j; 
			}
			allDays.add(dr);
		}
		
		int total = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = i+1; j <= n; j++) {
				int flag = 0;
				for (int k = 0; k < allDays.size(); k++) {
					if (allDays.get(k).ranking[i] > allDays.get(k).ranking[j]) {
						flag = 1;
						break;
					}
				}
				if (flag == 0) {
					//System.out.println(i+" "+ j);
					total ++;
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = i+1; j <= n; j++) {
				int flag = 0;
				for (int k = 0; k < allDays.size(); k++) {
					if (allDays.get(k).ranking[i] < allDays.get(k).ranking[j]) {
						flag = 1;
						break;
					}
				}
				if (flag == 0) {
					//System.out.println(i+" "+ j);
					total ++;
				}
			}
		}
		
		io.println(total);
		io.close();

	}

}
