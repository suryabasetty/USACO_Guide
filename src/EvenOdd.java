import java.util.Scanner;

public class EvenOdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		int odd = 0;
		int even = 0;
		
		for (int i = 0; i < n; i++) {
			int cur  = sc.nextInt();
			
			if ((cur % 2) == 0) {
				even++;
			}
			else {
				odd++;
			}
		}
		int numberOfGroups = 0;
		
		if (even == odd) {
			numberOfGroups = 2*odd;
		}
		
		else if (even > odd) {
			numberOfGroups = 2*odd + 1;
		}
		
		else {
			int rem = odd - even;
			
			if ((rem % 3) == 0) {
				numberOfGroups = 2*even + (rem/3)*2;
			}
			else if ((rem % 3) == 2) {
				numberOfGroups = 2*even + (rem/3)*2 + 1;
			}
			else {
				numberOfGroups = 2*even + (rem/3)*2 - 1;
			}
		}
		
		System.out.println(numberOfGroups);
	}

}
