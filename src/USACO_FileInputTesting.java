import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;
import java.io.*;



public class USACO_FileInputTesting {
	
	static Kattio io;
    static {
    	//System.out.println("in Try 1");
    	
            try {
				io = new Kattio("paint");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("in Try");
         
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// System.out.println("Hello, Check this out");
		
		// BufferedReader br = new BufferedReader(new FileReader("problemname.in"));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		
	
    //System.out.println("Hi");
	//int i = 0;
   
    	int cowx = io.nextInt();
    	int cowy = io.nextInt();
    	int farmerx = io.nextInt();
    	int farmery= io.nextInt();
    	
    	int intersection  = Math.min(farmery, cowy) - Math.max(cowx, farmerx);
    	
    	if (intersection < 0) {intersection = 0;}
    	
    	
    	
    	io.println((cowy - cowx) + (farmery - farmerx) - intersection);
    
    //System.out.print(io.checkError());
	io.close();
		    
		 
		

	}
	
	

}
