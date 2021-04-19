import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;



public class BadMilk {
	
	
	static class Consumption {
		int milk;
		int time;
	}
	
	static class Friend {
		int friend;
		ArrayList<Consumption> consumptions = new ArrayList<Consumption> (); 
	}
	
	
	
	static Kattio io;
	static {
    	//System.out.println("in Try 1");
    	
            try {
				io = new Kattio("badmilk");
		        //io = new Kattio("problemname");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("in Try");
         
    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int friends = io.nextInt();
		int milkTypes = io.nextInt();
		int numberOfLines = io.nextInt();
		int numberOfInfections = io.nextInt();
		int[] milkArray = new int[milkTypes + 1];
		
		for (int i = 0; i < milkArray.length; i++) {
			milkArray[i] = 1;
		}
		
		ArrayList<Friend> allFriends = new ArrayList<Friend> ();
		for (int i = 0; i < friends + 1; i++) {
			Friend curFriend = new Friend();
			curFriend.friend =i;
			allFriends.add(curFriend);
		}
		
		for (int i = 0; i < numberOfLines; i++) {
			int current = io.nextInt();
			Consumption curConsumption = new Consumption ();
			curConsumption.milk = io.nextInt();
			curConsumption.time = io.nextInt();
			allFriends.get(current).consumptions.add(curConsumption);
		}
		
		
		
		for (int i = 0; i < numberOfInfections; i++) {
			int infected = io.nextInt();
			int time = io.nextInt();
			
			Friend f = allFriends.get(infected);
			int[] curInfect = new int[milkTypes + 1];
			for (int k = 0; k < f.consumptions.size(); k++) {
				
			
				if (time > f.consumptions.get(k).time) {
					curInfect[f.consumptions.get(k).milk] = 1;
					
				}
				
			}
			
			
			for (int z = 0; z < milkArray.length; z++) {
				if ((milkArray[z] == 1) && (curInfect[z] == 1)) {
					milkArray[z] = 1;
					
				}
				else {
					milkArray[z] = 0;
				}
			}
		}
		
		
		
		int maxInfections = 0;
		
		for (int i = 0; i < milkArray.length; i++) {
			if (milkArray[i] == 0) {
				continue;
			}
			int currentInfections = 0;
			for (int z = 0; z < allFriends.size(); z++) {
				for (int g = 0; g < allFriends.get(z).consumptions.size(); g++) {
					if (i == allFriends.get(z).consumptions.get(g).milk) {
						currentInfections++;
						break;
					}
				}
			}
			maxInfections = maxInfections > currentInfections ? maxInfections : currentInfections;
		}
		
		io.println(maxInfections);
		io.close();
	}
	
	
}
