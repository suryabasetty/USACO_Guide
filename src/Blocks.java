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


public class Blocks {
	
	static Kattio io;
	static {
    	//System.out.println("in Try 1");
    	
            try {
				io = new Kattio("blocks");
		        //io = new Kattio("problemname");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("in Try");
         
    }
	
	static class Block {
		String front;
		String back;
		int[] count = new int[26];
	}
	static List<Block> allBlocks = new ArrayList<Block> ();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//System.out.println(Character.getNumericValue('Z'));
		int totalInputs = io.nextInt();
		for (int i = 0; i < totalInputs; i++) {
			
			Block current = new Block ();
			current.front = io.next();
			current.back = io.next();
			allBlocks.add(current);
		}
		
		for (int i = 0; i < totalInputs; i++) {
			process(allBlocks.get(i));
		}
		
		for (int i = 0; i < 26; i++) {
			int out = 0;
			for (int j = 0; j < totalInputs; j++) {
				out += allBlocks.get(j).count[i];
			}
			io.println(out);
		}
		io.close();
	}
	
	public static void process (Block block) {
		int[] temp1 = new int[26];
		int[] temp2 = new int[26];
		for (int i = 0; i < block.front.length(); i++) {
			temp1[Character.getNumericValue(block.front.charAt(i)) - 10]++;
		}
		for (int i = 0; i < block.back.length(); i++) {
			temp2[Character.getNumericValue(block.back.charAt(i)) - 10]++;
		}
		
		for (int i = 0; i< 26; i++) {
			block.count[i] = Math.max(temp1[i], temp2[i]);
		}
	}
}
