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

public class ModernArt {
	
	static Kattio io;
	static {
    	//System.out.println("in Try 1");
    	
            try {
				io = new Kattio("art");
		        //io = new Kattio("problemname");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("in Try");
         
    }
	
	static ArrayList<ArrayList<Integer>> combinations = new ArrayList<ArrayList<Integer>> ();
	static int[] visited;
	static int[][] a;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		visited = new int[10];
		
		for (int i = 0; i <= 9; i++) {
			ArrayList<Integer> empty = new ArrayList<Integer> ();
			combinations.add(empty);
			
		}
		int n = io.nextInt();
		
		a = new int[n][];
		for (int i = 0; i < n; i++) {
			a[i] = new int[n];
			visited[i] = 0;
		}
		
		for (int i = 0; i < n; i++) {
			String line = io.next();
			for (int j = 0; j < n; j++) {
				a[i][j] = Character.getNumericValue(line.charAt(j));
			}
		}
		//addToPossibleList(2, n);
		//System.out.println(combinations);
		for (int i = 1; i <= 9; i++) {
			addToPossibleList(i, n);
		}
		
		int possible = 0;
		for (int i = 0; i < combinations.size(); i++) {
			if ((visited[i] == 1) && (combinations.get(i).size() == 0)) {
				possible++;
			}
		}
	
	//System.out.println(combinations);
	//addToPossibleList (2, n);
	//System.out.println(rectangleOfIndex (2,n));
	//System.out.println(rectangleOfIndex (3,n));
	//System.out.println(rectangleOfIndex (8,n));
	//System.out.println(rectangleOfIndex (7,n));
	io.println(possible);
	io.close();
	}
	
	public static void addToPossibleList(int i, int n) {
		
		if (visited[i] == 1) {
			return;
		}
		List<Integer> intersectingColor = new ArrayList<Integer> ();
		
		List<Integer> getRectangle = new ArrayList<Integer> ();
		getRectangle = rectangleOfIndex (i, n);
		//System.out.println(getRectangle);
		if (getRectangle.size() == 0) {
			
			return;
		}
		for (int j = getRectangle.get(0); j <= getRectangle.get(0) + getRectangle.get(2); j++) {
			for (int k = getRectangle.get(1); k <= getRectangle.get(1) + getRectangle.get(3); k++) {
				//System.out.println(j +" "+ k);
				if (a[j][k] !=i) {
					intersectingColor.add(a[j][k]);
				}
			}
		}
		//System.out.println("Hi");
		
		Collections.sort(intersectingColor);
		for (int m = 0; m < intersectingColor.size() - 1; m++) {
			if (intersectingColor.get(m) == intersectingColor.get(m+ 1)) {
				intersectingColor.remove(m);
				m--;
			}
		}
		
		//System.out.println(intersectingColor);
		visited[i] = 1;
		//System.out.println(intersectingColor.size());
		for (int j = 0; j < intersectingColor.size(); j++) {
			//System.out.println(j);
			//System.out.println(intersectingColor.get(j));
			//System.out.print(combinations.get(7));
			combinations.get(intersectingColor.get(j)).add(i);
		}
	}
	
	public static List<Integer> rectangleOfIndex (int i, int n) {
		List<Integer> getRectangle = new ArrayList<Integer> ();
		
		int leftMost = Integer.MAX_VALUE;
		int rightMost = Integer.MIN_VALUE;
		int topMost = Integer.MAX_VALUE;
		int bottomMost = Integer.MIN_VALUE;
		
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < n; k++) {
				if (a[j][k] == i) {
					leftMost = leftMost < j ? leftMost : j;
					rightMost = rightMost > j ? rightMost : j;
					bottomMost = bottomMost > k ? bottomMost : k;
					topMost = topMost < k ? topMost : k;
				}
			}
		}
		
		if (leftMost == Integer.MAX_VALUE) {ArrayList<Integer> empty = new ArrayList<Integer> ();return empty;}
		
		getRectangle.add(leftMost); 
		getRectangle.add(topMost);
		getRectangle.add(rightMost-leftMost);
		getRectangle.add(bottomMost-topMost);
		
		return getRectangle;
	}

}
