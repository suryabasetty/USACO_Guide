import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;



public class Measurement {
	
	static class Cow {
		String name;
		int currentMilk;
		boolean isTop;
		char code;
		
	}
	static Cow mildred = new Cow();
	static Cow bessie = new Cow();
	static Cow elsie = new Cow();
	
	
	
	static int topMilk = 7;
	static List<Character> topList = new ArrayList<Character> (); 
	static int totalChange = 0;
	static class Input {
		String cowName;
		int day;
		int milkChange;
	}
	
	static Kattio io;
	
    static {
    	//System.out.println("in Try 1");
    	
            try {
				io = new Kattio("measurement");
		        //io = new Kattio("problemname");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("in Try");
         
    }
    
    public static void areSame (List<Character> newList) {
    	
    	if (topList.size() != newList.size()) {totalChange++; topList = newList; return;} //return false;}
    	
    	Collections.sort(topList);
    	Collections.sort(newList);
    	
    	for (int i = 0; i < topList.size(); i++) {
    		if (topList.get(i) != newList.get(i)) {totalChange++; topList = newList; return;}
    	}
    	//totalChange++;
    	//return true;
    }
    
    public static void processCowInput (Input input) {
    	if (input.cowName.charAt(0) == 'M') {
    		mildred.currentMilk += input.milkChange;
    		//topMilk = topMilk < mildred.currentMilk ? mildred.currentMilk : topMilk;
    		
    	}
    	else if (input.cowName.charAt(0) == 'B') {
    		bessie.currentMilk += input.milkChange;
    		//topMilk = topMilk < bessie.currentMilk ? bessie.currentMilk : topMilk;
    	}
    	else {
    		elsie.currentMilk += input.milkChange;
    		//topMilk = topMilk < elsie.currentMilk ? elsie.currentMilk : topMilk;
    	}
    	int temp = Math.max(elsie.currentMilk, bessie.currentMilk);
    	topMilk = Math.max(mildred.currentMilk, temp);
    	formTopsList();
    }
    
    public static void formTopsList() {
    	
    	List<Character> newList = new ArrayList<Character> ();
    	if (mildred.currentMilk == topMilk) {
    		newList.add('M');
    	}
    	if (bessie.currentMilk == topMilk) {
    		newList.add('B');
    	}
    	if (elsie.currentMilk == topMilk) {
    		newList.add('E');
    	}
    	//if (newList.size() == 0) {return ;}
    	areSame(newList);
    	//System.out.print(newList);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int totalInputs = io.nextInt();
		List<Input> allInputs = new ArrayList<Input> ();
		for (int i = 0; i < totalInputs; i++) {
			Input input = new Input();
			input.day = io.nextInt();
			input.cowName = io.next();
			input.milkChange = io.nextInt();
			allInputs.add(input);
		}
		
		allInputs.sort((l1, l2) -> Integer.compare(l1.day, l2.day));
		
		topList.add('M');
		topList.add('E');
		topList.add('B');
		
		mildred.currentMilk = 7;
		bessie.currentMilk = 7;
		elsie.currentMilk = 7;
		mildred.isTop = true;
		bessie.isTop = true;
		elsie.isTop = true;
		mildred.code = 'm';
		bessie.code = 'b';
		elsie.code = 'e';
		
		//System.out.println(allInputs.size());
		
		for (int i = 0; i < allInputs.size(); i++) {
			processCowInput(allInputs.get(i));
		}
		
		io.println(totalChange);
		io.close();
		
	}

}
