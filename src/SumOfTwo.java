import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class SumOfTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		int sum = sc.nextInt();
		
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer> ();
		int[] array = new int[n];
		
		for (int i = 0; i < n; i++) {
			int cur = sc.nextInt();
			hm.put(cur, i);
			array[i] = cur;
		}
		
		int flag = 0;
		for (int i = 0; i <n ; i++) {
			int pre = array[i];
			int rem = sum - array[i];
			
			if (hm.containsKey(rem)) {
				if (hm.get(rem) != i) {
					//System.out.println(hm.get(rem));
					System.out.println(i+1 +" " + (hm.get(rem)+1));
					flag = 1;
					break;
				}
			}
		}
		
		if (flag == 0) {
			System.out.println("IMPOSSIBLE");
		}
	}

}
