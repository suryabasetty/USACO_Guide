import java.util.Scanner;

public class AppleDivision {
	
	static long minWeight =Long.MAX_VALUE;
	static long total = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int n = (int) sc.nextLong();
		long[] weights = new long[n];
		
		for (int i = 0; i < n; i++) {
			weights[i] = sc.nextLong();
			total += weights[i];
		}
		
		//System.out.print("Hi");
		subsetSum (0, weights, 0);
		
		System.out.print(minWeight);
		
	}
	
	public static void subsetSum (int i, long[] weights, long prevWeight) {
		//System.out.print("Hi");
		if (i == weights.length) {
			return;
		}
		
		long includeWeight = prevWeight + (weights[i]);
		
		long leftWeight = total - includeWeight;
		
		
		minWeight = minWeight > (Math.abs(leftWeight - includeWeight)) ? (Math.abs(leftWeight - includeWeight)) : minWeight;
		
		
		subsetSum (i + 1, weights, prevWeight + weights[i]);
		subsetSum (i + 1, weights, prevWeight);
	}

}
