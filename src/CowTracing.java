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
import java.util.StringTokenizer;


public class CowTracing {
	
	static Kattio io;
	static {
    	//System.out.println("in Try 1");
    	
            try {
				//io = new Kattio("tracing");
		        io = new Kattio("problemname");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("in Try");
         
    }
	
	static class Cow {
		int indexer;
		int kMin;
		int kMax;
		boolean isZero;
	}
	
	static class Interaction {
		Cow firstCow;
		Cow secondCow;
		int time;
	}
	
	static ArrayList<Interaction> allInput = new ArrayList<Interaction> ();
	static ArrayList<Cow> allCows = new ArrayList<Cow> ();
	static int[] finalState;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int n = io.nextInt();
		finalState = new int[n];
		int interactions = io.nextInt();
		String finalStateString = io.next();
		for (int i = 0; i < n; i++) {
			finalState[i] = Character.getNumericValue(finalStateString.charAt(i));
		}
		for (int i = 0; i < n; i++) {
			//System.out.println(finalState[i]);
		}
		
		for (int i = 0; i < n; i++) {
			Cow current = new Cow();
			current.indexer = i;
			
			allCows.add(current);
		
		}
		
		for (int i = 0; i < interactions; i++) {
			Cow first = new Cow();
			Cow second = new Cow();
			Interaction interaction = new Interaction();
			interaction.time = io.nextInt();
			first.indexer = io.nextInt() - 1;
			second.indexer = io.nextInt() - 1;
			interaction.firstCow = first;
			interaction.secondCow = second;
			
			allInput.add(interaction);
		}
		
		allInput.sort((l1, l2) -> Integer.compare(l1.time, l2.time));
		
		//calculatePossibilities(1, 4);
		for (int i = 0; i < n; i++) {
			calculatePossibilities(i, n);
		}
		
	//	System.out.println(allCows.get(0//).kMax +" " +allCows.get(0).kMax);
		int totalMax = Integer.MIN_VALUE;
		int totalMin = Integer.MAX_VALUE;
		int total = 0;
		for (int i = 0; i < n; i++) {
			if (allCows.get(i).isZero) {
				total++;
				totalMin = totalMin < allCows.get(i).kMin ? totalMin : allCows.get(i).kMin;
				totalMax = totalMax > allCows.get(i).kMax ? totalMax : allCows.get(i).kMax;
			}
		}
		
		if (totalMax == Integer.MAX_VALUE) {
			io.println(total +  " " + totalMin + " " + "Infinity");
		}
		else {
			io.println(total +  " " + totalMin + " " + totalMax);
		}
		io.close();
	}
	
	public static void calculatePossibilities (int index, int n) {
		
		int[] currentState = new int[n];
		for (int j = 0; j < n; j++) {
			if ( j == index) {
				currentState[j] = 1;
			}
			else {
				currentState[j] = 0;
			}
		}
		
		int[] kminArray = new int[n];
		int[] kmaxArray = new int[n];
		int[] totalInteractions = new int[n];
		
		for (int i = 0; i < n; i++) {
			
			kminArray[i] = 0;
			kmaxArray[i] = Integer.MAX_VALUE;
			totalInteractions[i] = 0;
			
			
		}
		
		
		if (areSame(currentState, finalState)) {
			allCows.get(index).isZero = true;
			return;
		}
		
		//System.out.println(allInput.get(0).firstCow) ;//.indexer);
		
		
		
		for (int i = 0; i < allInput.size(); i++) {
			int first = allInput.get(i).firstCow.indexer;
			int second = allInput.get(i).secondCow.indexer;
			//System.out.println(first +" " + second);
			if ((currentState[first] == 0) && (currentState[second] == 0)) {
				continue;
			}
			else if ((currentState[first] == 0) && (currentState[second] == 1)) {
				//currentState[first] = 1;
				
				//System.out.println("hi2");
				if (finalState[first] == 1) {
					if (kmaxArray[second] == Integer.MAX_VALUE) {
						
						kminArray[first] = totalInteractions[second] + 1;
						currentState[first] = 1;
						
						//totalInteractions[first] ++;
					}
					
					
					
				}
				
				else {
					kmaxArray[second] = kmaxArray[second] < totalInteractions[second] ? kmaxArray[second] : totalInteractions[second];
				}
				totalInteractions[second] ++;
			}
			else if ((currentState[first] == 1) && (currentState[second] == 0)) {
				
				//System.out.println("Hi");
				if (finalState[second] == 1) {
					
					if (kmaxArray[first] == Integer.MAX_VALUE) {
						kminArray[second] = totalInteractions[first] + 1;
						currentState[second] = 1;
						//totalInteractions[second] ++;
						//System.out.println("Hi");
					}
					
					
				}
				
				else {
					kmaxArray[first] = kmaxArray[first] < totalInteractions[first] ? kmaxArray[first] : totalInteractions[first];
				}
				totalInteractions[first] ++;
			}
			else {
				
				if (totalInteractions[first] + 1<= kminArray[second]) {
					if (kmaxArray[first] == Integer.MAX_VALUE) {kminArray[second] = totalInteractions[first] + 1; totalInteractions[first]++;
					totalInteractions[second] = 0; continue;}
				}
				
				
				else if (kminArray[second] + totalInteractions[first] + 1 <= kminArray[first]){
					if (kmaxArray[second] == Integer.MAX_VALUE) {kminArray[first] =  totalInteractions[second] + 1; totalInteractions[first] = 0;
					totalInteractions[second]++; continue;}
				}
				
				else {}
				
				totalInteractions[first]++;
				totalInteractions[second]++;
			}
			
			
		}
		
		
		
		if (!areSame(currentState, finalState)) {
			allCows.get(index).isZero = false;
			return;
		}
		
		int minp = Integer.MIN_VALUE;
		int maxp = Integer.MAX_VALUE;
		
		//System.out.println(kminArray[0]+" " +kmaxArray[0]);
		//System.out.println(kminArray[1]+" " +kmaxArray[1]);
		//System.out.println(kminArray[2]+" " +kmaxArray[2]);
		//System.out.println(kminArray[3]+" " +kmaxArray[3]);
		for (int i = 0; i < n; i++) {
			if (currentState[i] == 1) {
				minp = minp < kminArray[i] ? kminArray[i] : minp;
				maxp = maxp > kmaxArray[i] ? kmaxArray[i] : maxp;
			}
			
		}
		
		
		
		if (maxp < minp) {
			allCows.get(index).isZero = false;
			return;
		}
		
		//System.out.println(index +" "+minp+" "+maxp);
		allCows.get(index).isZero = true;
		allCows.get(index).kMax = maxp;
		allCows.get(index).kMin = minp;
		return;
		
		
	}
	
	public static boolean areSame (int[] a1, int[] a2) {
		
		for (int i = 0; i < a1.length; i++) {
			if (a1[i] != a2[i]) {
				return false;
			}
		}
		
		return true;
	}

}
