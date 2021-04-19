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

public class Mowing {
	
static Kattio io;
	
    static {
    	//System.out.println("in Try 1");
    	
            try {
				io = new Kattio("mowing");
		        //io = new Kattio("problemname");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("in Try");
         
    }
    static class Coordinate {
    	int x;
    	int y;
    	int lastVisit;
    }
    static List<Coordinate> grid = new ArrayList<Coordinate> ();
    static int curX = 0;
	static int curY = 0;
	static int time = 0;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = io.nextInt();
		int t = 0;
		int time = 0;
		for (int i = 0; i < n; i++) {
			
			String direction = io.next();
			int steps = io.nextInt();
			calculateNext(direction, steps);
			time = time + steps;
			
		}
		if (min == Integer.MAX_VALUE) {min = -1;}
		io.println(min);
		io.close();

	}
	
	public static void calculateNext (String direction, int steps) {
		int nextX = 0;
		int nextY = 0;
		if (direction.charAt(0) == 'E') {
			for (int i = 0; i < steps; i++) {
				Coordinate coordinate = new Coordinate ();
				 
				coordinate.x = curX + 1;
				coordinate.y = curY;
				addToGrid(coordinate, time + 1);
				curX++;
				time++;
				
			    }
		}
		else if (direction.charAt(0) == 'W') {
			for (int i = 0; i < steps; i++) {
				Coordinate coordinate = new Coordinate ();
				 
				coordinate.x = curX - 1;
				coordinate.y = curY;
				addToGrid(coordinate, time + 1);
				curX--;
				time++;
				
			    }
			
		}
		else if (direction.charAt(0) == 'N') {
			for (int i = 0; i < steps; i++) {
				Coordinate coordinate = new Coordinate ();
				 
				coordinate.y = curY + 1;
				coordinate.x = curX;
				addToGrid(coordinate, time + 1);
				curY++;
				time++;
				
			    }
		}
		else {
			for (int i = 0; i < steps; i++) {
				Coordinate coordinate = new Coordinate ();
				 
				coordinate.y = curY - 1;
				coordinate.x = curX;
				addToGrid(coordinate, time + 1);
				curY--;
				time++;
				
			    }
		}
		return;
	}
	
	public static void addToGrid (Coordinate coordinate, int time) {
		//System.out.println(coordinate.x + " " + coordinate.y + " " + time);
		for (int i = 0; i < grid.size(); i++) {
			if ((coordinate.x == grid.get(i).x) && (coordinate.y == grid.get(i).y)) {
				min = min > (time - grid.get(i).lastVisit) ? time - grid.get(i).lastVisit : min;
				grid.get(i).lastVisit = time;
				return;
			}
		}
		coordinate.lastVisit = time;
		grid.add(coordinate);
		return;
	} 

}
