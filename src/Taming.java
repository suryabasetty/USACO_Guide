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


public class Taming {
	
	static Kattio io;
	static {
    	//System.out.println("in Try 1");
    	
            try {
				//io = new Kattio("taming");
		        io = new Kattio("problemname");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("in Try");
         
    }
	static int[] minpossibleFights;
	static int[] maxpossibleFights;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = io.nextInt();
		int[] log  = new int[n];
		for (int i = 0; i < n; i++) {
			log[i] = io.nextInt();
		}
		
		minpossibleFights = new int[n];
		minpossibleFights[0] = 1;
		int flag = 0;
		
		for (int i = 1; i < n; i++) {
			if (log[i] != -1) {
				int j;
				if ((i - log[i]) < 0) {
				flag = 1;
				break;
				}
				for (j = i; j >=i - log[i]; j--) {
					
					if (minpossibleFights[j] != 1) {
						minpossibleFights[j] = 2;
					}
					else {
						flag = 1;
					}
				}
				minpossibleFights[j+1] = 1;
			}
		}
		
		for (int i = 0; i < n; i++) {
			System.out.print(minpossibleFights[i] + " ");
		}
		
		int zeroes = 0;
		int ones  = 0;
		if (false) {
			io.println("-1");
		}
		else {
			for (int i = 0; i < n; i++) {
				if (minpossibleFights[i] == 0) {
					zeroes++;
				}
				else if (minpossibleFights[i] == 1) {
					ones++;
				}
			}
		}
		io.println(ones + " " + (ones + zeroes));
		io.close();

	}

}
