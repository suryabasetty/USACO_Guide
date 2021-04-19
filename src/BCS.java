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

public class BCS {
	
	static Kattio io;
	static {
    	//System.out.println("in Try 1");
    	
            try {
				io = new Kattio("bcs");
		        //io = new Kattio("problemname");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("in Try");
         
    }
	
	static class Piece {
		ArrayList<ArrayList<Character>> piece;
		
		ArrayList<ArrayList<ArrayList<Character>>> possibleCombinations = new ArrayList<ArrayList<ArrayList<Character>>>();
		
		int topFreedom = 0;
		int bottomFreedom = 0;
		int leftFreedom = 0;
		int rightFreedom = 0;
		int vertical = 0;
		int horizantal = 0;
	}
	
	static ArrayList<Piece> shop = new ArrayList<Piece> ();
	
	static ArrayList<ArrayList<Character>> initialPiece = new ArrayList<ArrayList<Character>> ();
	static ArrayList<Character> empty = new ArrayList<Character> ();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = io.nextInt();
		int k = io.nextInt();
		
		for (int j = 0; j < n; j++) {
			ArrayList<Character> line = new ArrayList<Character> ();
			String inputLine = io.next();
			for (int i = 0; i < n; i++) {
				line.add(inputLine.charAt(i));
			}
			initialPiece.add(line);
		}
		
		for (int i = 0; i < n; i++) {
			empty.add('.');
		}
		//System.out.println();
		
		for (int z = 0; z < k; z++) {
			ArrayList<ArrayList<Character>> currentPiece = new ArrayList<ArrayList<Character>> ();
			for (int j = 0; j < n; j++) {
				ArrayList<Character> line = new ArrayList<Character> ();
				String inputLine = io.next();
				for (int i = 0; i < n; i++) {
					line.add(inputLine.charAt(i));
				}
				currentPiece.add(line);
			}
			Piece newPiece = new Piece();
			newPiece.piece = currentPiece;
			shop.add(newPiece);
			
		}
		
		for (int i = 0; i < k; i++) {
			calculateTopFreedom(i, n);
			calculateBottomFreedom(i, n);
			calculateLeftFreedom(i, n);
			calculateRightFreedom(i, n);
			shop.get(i).horizantal = shop.get(i).leftFreedom + shop.get(i).rightFreedom;
			shop.get(i).vertical = shop.get(i).topFreedom + shop.get(i).bottomFreedom;
			
			//System.out.println(shop.get(i).topFreedom+" "+shop.get(i).bottomFreedom+" "+shop.get(i).leftFreedom+" "+shop.get(i).rightFreedom);
		}
		for (int i = 0; i < k; i++) {
			alignTopLeft(i, n);
		}
		for (int i = 0; i < k; i++) {
			
			calculateCombinations(i, n);
		}
		
		
		
		for (int l = 0; l < shop.get(0).possibleCombinations.size(); l++) {
		//	printComb(shop.get(0).possibleCombinations.get(l), n);
		//	System.out.println("----------");
		}
		//printComb(shop.get(0).possibleCombinations.get(2), n);
		//System.out.println("-------");
		//printComb(shop.get(2).possibleCombinations.get(0), n);
		//System.out.println(shop.get(0).possibleCombinations);
		for (int i = 0; i < k; i++) {
			for (int j =i+1; j < k; j++) {
				if (check(i, j, n))
				{
					io.println((i+1) + " " + (j+1));
					io.close();
					return;
					
				}
			}
		}
		io.close();
	}
	
	public static char combChar (char a, char b) {
		if ((a == '.') && (b == '.')) {
			return '.';
		}
		else {
			return '#';
		}
	}
	
	public static boolean checkIfImposed (ArrayList<ArrayList<Character>> temp1, ArrayList<ArrayList<Character>> temp2, int n) {
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if ((temp1.get(i).get(j) == '#') && (temp2.get(i).get(j) == '#')) {
					return false;
					}
				else if (combChar(temp1.get(i).get(j), temp2.get(i).get(j)) != initialPiece.get(i).get(j)) {
					return false;
					}
				}
 		}
		
		return true;
	}
	
	public static boolean check (int i, int j, int n) {
		
		for (int p = 0; p <shop.get(i).possibleCombinations.size(); p++) {
			for (int q = 0; q < shop.get(j).possibleCombinations.size();q++) {
				if (checkIfImposed(shop.get(i).possibleCombinations.get(p), shop.get(j).possibleCombinations.get(q), n)) {
					return true;
				}
					 
			}
		}
		
		return false;
	}
	
	public static void printComb(ArrayList<ArrayList<Character>> temp, int n) {
		for (int i = 0; i < n; i++) {
			for (int k = 0; k < n; k++) {
				System.out.print(temp.get(i).get(k));
			}
			System.out.println();
		}
	}
	
	public static void calculateCombinations(int i, int n) {
		
		ArrayList<ArrayList<Character>> temp = new ArrayList<ArrayList<Character>> ();
		temp = intialize(n);
		//System.out.println(temp);
		//System.out.println(shop.get(i).horizantal);
		//System.out.println(shop.get(i).vertical);
		for (int p = 0; p <= shop.get(i).vertical; p++) {
			for (int k = 0; k<= shop.get(i).horizantal; k++) {
				for (int s = 0; s < n - p; s++) {
					for (int t = 0; t < n - k; t++) {
						temp.get(p+s).set(k+t, shop.get(i).piece.get(s).get(t));
					}
				}
				//printComb(temp, n);
				//System.out.println("-------" + i + shop.get(i).possibleCombinations.size());
				//System.out.println("---------------");
				shop.get(i).possibleCombinations.add(temp);
				temp = intialize(n);
				//System.out.println(shop.get(i).possibleCombinations);
				
			}
		}
		//System.out.println(temp);
		
	} 
	
	public static ArrayList<ArrayList<Character>> intialize(int n) {
		ArrayList<ArrayList<Character>> temp = new ArrayList<ArrayList<Character>> ();
		for (int i = 0; i < n; i++) {
			ArrayList<Character> line = new ArrayList<Character> ();
			for (int j = 0; j < n; j++) {
				line.add('.');
			}
			temp.add(line);
		}
		return temp;
	}
	
	public static void alignTopLeft (int i, int n) {
		
		//System.out.println(shop.get(i).piece);
		
		while (shop.get(i).topFreedom > 0) {
			shop.get(i).piece.remove(0);
			shop.get(i).piece.add(empty);
			shop.get(i).topFreedom --;
			
		}
		
		while (shop.get(i).leftFreedom > 0) {
			for (int l = 0; l < n; l++) {
				shop.get(i).piece.get(l).remove(0);
				shop.get(i).piece.get(l).add('.');
			}
			shop.get(i).leftFreedom --;
		}
		
		//System.out.println(shop.get(i).piece);
	}
	
	public static void calculateTopFreedom (int i, int n) {
		for (int l = 0; l < n; l++) {
			for (int m = 0; m < n; m++) {
				if (shop.get(i).piece.get(l).get(m) == '#') {
					return;
				}
			}
			shop.get(i).topFreedom++;
		}
	}
	
	public static void calculateBottomFreedom (int i, int n) {
		for (int l = n-1; l >= 0; l--) {
			for (int m = 0; m < n; m++) {
				if (shop.get(i).piece.get(l).get(m) == '#') {
					return;
				}
			}
			shop.get(i).bottomFreedom++;
		}
	}
	
	public static void calculateLeftFreedom (int i, int n) {
		for (int l = 0; l < n; l++) {
			for (int m = 0; m < n; m++) {
				if (shop.get(i).piece.get(m).get(l) == '#') {
					return;
				}
			}
			shop.get(i).leftFreedom++;
		}
	}
	public static void calculateRightFreedom (int i, int n) {
		for (int l = n-1; l >= 0; l--) {
			for (int m = 0; m < n; m++) {
				if (shop.get(i).piece.get(m).get(l) == '#') {
					return;
				}
			}
			shop.get(i).rightFreedom++;
		}
	}
	
	
	
}
