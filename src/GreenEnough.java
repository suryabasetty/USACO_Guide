import java.util.Scanner;

public class GreenEnough {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		int[][] farm = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				farm[i][j] = sc.nextInt();
			}
		}
		
		boolean[][][] dynamic = new boolean[n][n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < j; k++) {
					if (farm[i][k] < 100) {
						dynamic[i][j][k] = false;
						break;
					}
					dynamic[i][j][k] = true;
				}
			}
		}
	}

}
