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
import java.util.Scanner;
import java.util.StringTokenizer;




public class StuckInRut {
	static List<Coordinates> all = new ArrayList<Coordinates> ();
	static class Coordinates {
		int x;
		int y;
		int grazed = -1;
		String direction;
		int index;
	}
	
	static Kattio io;
	
    static {
    	//System.out.println("in Try 1");
    	
            try {
				//io = new Kattio("shuffle");
		        io = new Kattio("problemname");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("in Try");
         
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int total = sc.nextInt();
		List<Coordinates> east = new ArrayList<Coordinates> ();
		List<Coordinates> north = new ArrayList<Coordinates> ();
		
	
		
		for (int i = 0; i < total; i++) {
			
			Coordinates current = new Coordinates();
			current.direction= sc.next();
			current.x = sc.nextInt();
			current.y = sc.nextInt();
			current.index = i;
			
			all.add(current);
			
		}
		
		all.sort((l1, l2) -> Integer.compare(l1.x, l2.x));
		//east.sort((l1, l2) -> Integer.compare(l1.x, l2.x));
		
		//System.out.println(north.get(0).x + " "+north.get(1).x+" "+north.get(2).x);
		//System.out.println(east.get(0).x + " "+east.get(1).x+" "+east.get(2).x);
		
		
		//List<Coordinates> temp = new ArrayList<Coordinates> ();
		for (int i = 0; i < total; i++) {
			if (all.get(i).direction.charAt(0) == 'E') {
				//temp.add(all.get(i));
			}
			
			else {
				//System.out.println(i);
				 block(i);
			}
		}
		
		all.sort((l1,l2) -> Integer.compare(l1.index, l2.index));
		//System.out.println(all.size());
		for (int i = 0; i < total; i++) {
			if (all.get(i).grazed == -1) {
				//io.println("Infinity"+ " " + all.get(i).x+ " "+all.get(i).y );
				System.out.println("Infinity");
			}
			else {
				//io.println(all.get(i).grazed + " " + all.get(i).x+ " "+all.get(i).y );
				System.out.println(all.get(i).grazed );
			}
		}
		//io.close();
	}
	
	public static void block (int northCoordinate)  {
		List<ArrayList<Integer>> intersectionList = new ArrayList<ArrayList<Integer>> ();
		
		int asize = all.size();
		
		for (int i = 0; i < northCoordinate ; i++) {
			if ((all.get(i).direction.charAt(0) == 'E') && (all.get(i).grazed == -1) && (all.get(northCoordinate).grazed == -1) && (all.get(northCoordinate).x > all.get(i).x)) {
				//ist<ArrayList<Integer>> intersectionList = new ArrayList<ArrayList<Integer>> ();
				
				int xmeet = all.get(northCoordinate).x;
				int ymeet = all.get(i).y;
				
				int eastDistance = xmeet - all.get(i).x;
				int northDistance = ymeet - all.get(northCoordinate).y;
				
				if (northDistance < 0) {
					//return;
					continue;
				}
				else if (eastDistance < 0) {
					//return ;
					continue;
				}
				else if (northDistance == eastDistance){
					//return;
					continue;
				}
				
				else {
					List<Integer> ind = new ArrayList<Integer> ();
					ind.add(eastDistance);
					ind.add(northDistance);
					ind.add(i);
					intersectionList.add((ArrayList<Integer>) ind);
				}
			}
		}
		
		intersectionList.sort((l1,l2) -> Integer.compare(l1.get(1), l2.get(1)));
		
		//System.out.println(intersectionList.size());
		//System.out.println(northCoordinate + " " + intersectionList);
		for (int i = 0; i < intersectionList.size(); i ++) {
			if (intersectionList.get(i).get(0) < intersectionList.get(i).get(1)) {
				all.get(northCoordinate).grazed = intersectionList.get(i).get(1);
				
				break;
			}
			else {
				all.get(intersectionList.get(i).get(2)).grazed = intersectionList.get(i).get(0);
				}
			}
		
		
	}
	
	

}
