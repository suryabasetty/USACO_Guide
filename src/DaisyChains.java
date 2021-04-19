import java.util.ArrayList;
import java.util.Scanner;

public class DaisyChains {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		ArrayList<Integer> allDaisy = new ArrayList<Integer> ();
		
		for (int i = 0; i < n ; i++) {
			allDaisy.add(sc.nextInt());
		}
		
		int total = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				//System.out.println(i+" "+j);
				int sum = 0;
				for (int  k = i; k <= j; k++) {
				
					sum += allDaisy.get(k);
				}
				//System.out.println(sum);
				int average = sum/(j - i + 1);
				
				if ((average * (j - i + 1)) == sum) {
					for (int  k = i; k <=j; k++) {
						if (average == allDaisy.get(k)) {
							//System.out.println(sum + " "+average+" "+i+" "+j);
							total++;
							break;
						}
					}
				}
				sum = 0;
				
			}
		}
		
		System.out.println(total);
	}

}
