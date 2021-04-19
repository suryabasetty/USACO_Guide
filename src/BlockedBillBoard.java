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



public class BlockedBillBoard {
	
	static Kattio io;
    static {
    	//System.out.println("in Try 1");
    	
            try {
				io = new Kattio("billboard");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("in Try");
         
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> billBoard1 = new ArrayList<Integer>();
		List<Integer> billBoard2 = new ArrayList<Integer>();
		List<Integer> bus = new ArrayList<Integer>();
		
		for (int i = 0; i < 4; i++) {billBoard1.add(io.nextInt());}
		for (int i = 0; i < 4; i++) {billBoard2.add(io.nextInt());}
		for (int i = 0; i < 4; i++) {bus.add(io.nextInt());}
		
		int totalAvailable =  rectArea(billBoard1) + rectArea(billBoard2) - ((findHeightIntersection(billBoard1, bus) * findWidthIntersection(billBoard1, bus)) + (findHeightIntersection(billBoard2, bus) * findWidthIntersection(billBoard2, bus)));
		
		io.println(totalAvailable);
		io.close();
		

	}
	
	public static int findHeightIntersection (List<Integer> rect1, List<Integer> rect2) {
		int intersection  = Math.min(rect1.get(3), rect2.get(3)) - Math.max(rect1.get(1), rect2.get(1));
		
		if (intersection < 0) {return 0;}
		return intersection;
	}
	
	public static int findWidthIntersection (List<Integer> rect1, List<Integer> rect2) {
		int intersection  = Math.min(rect1.get(2), rect2.get(2)) - Math.max(rect1.get(0), rect2.get(0));
		
		if (intersection < 0) {return 0;}
		return intersection;
	}
	
	public static int rectArea (List<Integer> rect) {
		
		return (rect.get(2) - rect.get(0)) * (rect.get(3) - rect.get(1));
	
	}

}
