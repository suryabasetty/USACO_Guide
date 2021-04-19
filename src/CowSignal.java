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



public class CowSignal {
	
	static Kattio io;
    static {
    	//System.out.println("in Try 1");
    	
            try {
				io = new Kattio("cowsignal");
		        //io = new Kattio("problemname");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("in Try");
         
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int height = io.nextInt();
		int width = io.nextInt();
		int amplify = io.nextInt();
		
		while (height > 0) {
			String line = io.next();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < amplify; j++) {
					sb.append(line.charAt(i));
				}
			} 
			for (int k = 0; k < amplify; k++) {
				io.println(sb);
			}
		
			
			height--;
		}
		io.close();

	}

}
