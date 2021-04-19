import java.util.Scanner;
import java.util.ArrayList;


public class NQueen {
	

	static ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>> ();
	
	static int total = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		
		int n = 8;
		
		for (int i = 0; i < n; i++) {
			String line = sc.next();
			ArrayList<Integer> row = new ArrayList<Integer> ();
			for (int j = 0; j < n; j++) {
				if (line.charAt(j) == '.') {
					row.add(0);
				}
				else {
					row.add(2);
				}
			}
			
			input.add(row);
		}
		
		recursive (0, n);
		
		System.out.println(total);
	}
	
	public static void recursive (int insert, int n) {
		if (insert == n) {
			total ++;
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (input.get(insert).get(i) != 2) {
				if (valid (insert, i, n)) {
					input.get(insert).set(i, 1);
					
					recursive ((insert + 1), n);
					input.get(insert).set(i, 0);
				}
			}
		}
		
		return;
	}
	
	public static boolean valid (int row, int column, int n) {
		
		for (int i = 0; i < n; i++) {
			if (input.get(row).get(i) == 1) {
				return false;
			}
		}
		
		for (int i = 0; i < n; i++) {
			if (input.get(i).get(column) == 1) {
				return false;
			}
		}
		
		for (int i = 0; i < n; i++) {
			if (((row - i - 1) < 0) || ((column - i - 1) < 0)) {
				break;
			}
			
			if (input.get(row-i-1).get(column-i-1) == 1) {
				return false;
			}
		}
		
		for (int i = 0; i < n; i++) {
			if (((row + i + 1) >= n) || ((column + i + 1) >= n)) {
				break;
			}
			
			if (input.get(row + i + 1).get(column + i + 1) == 1) {
				return false;
			}
		}
		
		for (int i = 0; i < n; i++) {
			if (((row + i + 1) >= n) || ((column-i-1) < 0)) {
				break;
			}
			
			if (input.get(row + i + 1).get(column-i-1) == 1) {
				return false;
			}
		}
		
		for (int i = 0; i < n; i++) {
			if (((row-i-1) < 0) || ((column + i + 1) >= n)) {
				break;
			}
			
			if (input.get(row-i-1).get(column + i + 1) == 1) {
				return false;
			}
		}
		
		
		return true;
	}

}
