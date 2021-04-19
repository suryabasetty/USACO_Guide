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


public class SquarePasture {
	static Kattio io;
    static {
    	//System.out.println("in Try 1");
    	
            try {
				//io = new Kattio("problemname");
				io = new Kattio("square");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("in Try");
         
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> xcord = new ArrayList<Integer> ();
		List<Integer> ycord = new ArrayList<Integer> ();
		
		for (int i = 0; i < 4; i++) {xcord.add(io.nextInt()); ycord.add(io.nextInt());}
		
		
		Collections.sort(xcord);
		Collections.sort(ycord);
		
		int SquareSide = Math.max((xcord.get(3) - xcord.get(0)), (ycord.get(3) - ycord.get(0)));
		
		io.println(SquareSide * SquareSide);
		
		io.close();
	}

}
