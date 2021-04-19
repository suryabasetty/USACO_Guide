import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;



public class Guess {
	
	static Kattio io;
	static {
    	//System.out.println("in Try 1");
    	
            try {
				io = new Kattio("guess");
		        //io = new Kattio("problemname");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("in Try");
         
    }
	
	static class Animal {
		String animal;
		ArrayList<String> qualities = new ArrayList<String> ();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = io.nextInt();
		
		ArrayList<Animal> allAnimals = new ArrayList<Animal> ();
		
		for (int i = 0; i < n; i++) {
			Animal currentAnimal = new Animal();
			currentAnimal.animal = io.next();
			int q = io.nextInt();
			for (int j = 0; j < q; j++) {
				currentAnimal.qualities.add(io.next());
			}
			allAnimals.add(currentAnimal);
		}
		
		int maxGuess = 0;
		
		for (int i = 0; i < n; i++) {
			
			Animal first  = allAnimals.get(i);
			for (int j = 0; j < n; j++) {
				int currentGuess = 0;
				if (i == j) {
					continue;
				}
				
				Animal second = allAnimals.get(j);
				
				for (int p = 0; p < first.qualities.size(); p++) {
					for (int s = 0; s < second.qualities.size(); s++) {
						if (first.qualities.get(p).equalsIgnoreCase(second.qualities.get(s))) {
							currentGuess++;
						}
						
					}
				}
				currentGuess++;
				maxGuess = maxGuess > currentGuess ? maxGuess : currentGuess;
				}
			}
			
			
		
		io.println(maxGuess);
		io.close();
	}

}
