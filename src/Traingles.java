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



public class Traingles {
	
	static Kattio io;
	static {
    	//System.out.println("in Try 1");
    	
            try {
				io = new Kattio("triangles");
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
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = io.nextInt();
		
		ArrayList<Coordinate> allCoordinates = new ArrayList<Coordinate> ();
		
		for (int i = 0; i < n; i++) {
			Coordinate  coordinate = new Coordinate ();
			coordinate.x = io.nextInt();
			coordinate.y = io.nextInt();
			allCoordinates.add(coordinate);
		}
		
		int maxArea = 0;
		
		for (int i = 0; i < allCoordinates.size(); i++) {
			int farX = 0;
			int farY = 0;
			for (int k = 0; k < allCoordinates.size(); k++) {
				if (allCoordinates.get(i).y == allCoordinates.get(k).y) {
					farX = farX > (Math.abs(allCoordinates.get(i).x - allCoordinates.get(k).x)) ? farX  : (Math.abs(allCoordinates.get(i).x - allCoordinates.get(k).x));
				}
			}
			for (int j = 0; j < allCoordinates.size(); j++) {
				if (allCoordinates.get(i).x == allCoordinates.get(j).x) {
					farY = farY > (Math.abs(allCoordinates.get(i).y - allCoordinates.get(j).y)) ? farY  : (Math.abs(allCoordinates.get(i).y - allCoordinates.get(j).y));
				}
			}
			
			maxArea = (maxArea > farX*farY) ? maxArea: farX*farY;
		}
		
		io.println(maxArea);
		io.close();
	}

}
