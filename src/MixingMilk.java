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



public class MixingMilk {
	
	static Kattio io;
    static {
    	//System.out.println("in Try 1");
    	
            try {
				io = new Kattio("mixmilk");
		        //io = new Kattio("problemname");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("in Try");
         
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long capacityA = io.nextLong();
		long milkA = io.nextLong();
		long capacityB = io.nextLong();
		long milkB = io.nextLong();
		long capacityC = io.nextLong();
		long milkC = io.nextLong();
		long remA = capacityA - milkA;
		long remB = capacityB - milkB;
		long remC = capacityC - milkC;
		
		//System.out.println(capacityA + " " + milkA + " " + capacityB + " " + milkB + " " + capacityC + " " + milkC);
		
		int operation = 1;
		
		while (operation <= 100) {
			if ((operation % 3) == 1) {
				if (milkA <= remB) {
					
					//System.out.println("1");
					milkB = milkB + milkA;
					remB = remB - milkA;
					remA = capacityA;
					milkA = 0;
				}
				else {
					
					milkB = capacityB;
					milkA = milkA - remB;
					remA = remA + remB;
					remB = 0;
					
				}
			}
			else if ((operation % 3) == 2) {
				
				//System.out.println("2");
				if (milkB <= remC) {
					
					milkC = milkC + milkB;
					remC = remC - milkB;
					remB = capacityB;
					milkB = 0;
				}
				else {
					
					milkC = capacityC;
					milkB = milkB - remC;
					remB = remB + remC;
					remC = 0;
					
				}
				
			}
		  else {
			  //System.out.println("3");
			  if (milkC <= remA) {
				
				milkA = milkA + milkC;
				remA = remA - milkC;
				remC = capacityC;
				milkC = 0;
			  }
			  else {
				
				milkA = capacityA;
				milkC = milkC - remA;
				remC = remC + remA;
				remA = 0;
			
			  }
		  }	
		
		 operation++;
		}
	
	//System.out.println(milkA + " " + " " + milkB + " " +milkC );
	io.println(milkA);	
	io.println(milkB);
	io.println(milkC);
	io.close();

	}
}
