import java.util.ArrayList;
import java.util.Scanner;

public class CreatingStrings {
	
	static ArrayList<String> output = new ArrayList<String> ();
	static int count = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		
		String input = sc.next();
		//int a = 97;
		//System.out.println((char)a);
		int[] store = new int[26];
		
		for (int i = 0; i < input.length(); i++) {
			store[Character.getNumericValue(input.charAt(i)) - 10]++;
		}
		StringBuffer sb =new StringBuffer ();
		recursive(store, sb, input.length(), 0);
		
		System.out.println(count);
		for (int i = 0; i < count; i++) {
			 System.out.println(output.get(i));
		}
	}
	
   public static void recursive (int[] store , StringBuffer sb, int n, int cur) {
	   if (cur == n) {
		  output.add(sb.toString());
		  count++;
	   }
	   
	   for (int i = 0; i < 26; i++) {
		   if (store[i] > 0) {
			   char c = (char) (i + 97);
			   sb.append(c);
			   store[i] --;
			   cur++;
			   recursive (store, sb, n, cur);
			   store[i] ++;
			   cur--;
			   sb.deleteCharAt(cur);
		   }
	   }
   }

}
