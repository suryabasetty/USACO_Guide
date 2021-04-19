import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;
import java.io.*;




public class ShellGame {
	
	static Kattio io;
    static {
    	//System.out.println("in Try 1");
    	
            try {
				io = new Kattio("shell");
		        //io = new Kattio("problemname");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("in Try");
         
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[4];
		a[0] = 0;
		a[1] = 1;
		a[2] = 2;
		a[3] = 3;
		
		int[] output = new int[4];
		output[0] = 0;
		output[1] = 0;
		output[2] = 0;
		output[3] = 0;
		
		int totalSwaps = io.nextInt();
		
		while (totalSwaps > 0) {
			
			int first = io.nextInt();
			int second = io.nextInt();
			int select = io.nextInt();
			
			int temp = a[first];
			a[first] = a[second];
			a[second] = temp;
			
			//System.out.println(temp +"  " + a[first] + " " + a[second]);
			
			output[a[select]]++;
			totalSwaps--;
		}
		
		
		Arrays.sort(output);
		io.println(output[3]);
		io.close();
	}

}
