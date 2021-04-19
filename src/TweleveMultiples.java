import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;


public class TweleveMultiples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//enum a = new Enumeration('a'); //= {};
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		TreeMap<Integer, Integer> twelve = new TreeMap<Integer, Integer> ();
		
		for (int i = 0; i < n; i++) {
			int input = sc.nextInt();
			twelve.putIfAbsent((input/12), 1);
		}
		int total = 0;
		ArrayList<Integer> gaps1 = new ArrayList<Integer> ();
		for(Entry<Integer, Integer> entry : twelve.entrySet()) {
			  int key = entry.getKey();
			  Integer value = entry.getValue();
			  
			  if (value == 1) {
				  gaps1.add(key);
				  total++;
			  }
			  
			}
		ArrayList<Integer> gaps = new ArrayList<Integer> ();
		
		for (int i = 0; i < gaps1.size() -1; i++) {
			gaps.add((gaps1.get(i+1) - gaps1.get(i) - 1) * 12);
		}
		
		
		
		Collections.sort(gaps);
		//System.out.println(gaps);
		int time = total*12;
		//System.out.println(time);
		while (total > k) {
			time = time + gaps.get(0);
			total --;
			gaps.remove(0);
		}
		
		System.out.println(time);
		sc.close();
	}
	
}
