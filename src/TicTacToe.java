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
import java.util.StringTokenizer;



public class TicTacToe {
	
	static Kattio io;
	static {
    	//System.out.println("in Try 1");
    	
            try {
				io = new Kattio("tttt");
		        //io = new Kattio("problemname");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("in Try");
         
    }
	static List<ArrayList<Character>> board = new ArrayList<ArrayList<Character>> (); 
	//static int totalSingle = 0;
	//static int totalDouble = 0;
	
	static List<String> winnersList = new ArrayList<String> ();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String line1 = io.next();
		String line2 = io.next();
		String line3 = io.next();
		
		ArrayList<Character> listline1 = new ArrayList<Character> ();
		ArrayList<Character> listline2 = new ArrayList<Character> ();
		ArrayList<Character> listline3 = new ArrayList<Character> ();
		for (int i = 0; i < 3; i++) {
			listline1.add(line1.charAt(i));
			listline2.add(line2.charAt(i));
			listline3.add(line3.charAt(i));
		}
		//System.out.println(listline1 + " " + listline2 + " " + listline3);
		board.add(listline1);
		board.add(listline2);
		board.add(listline3);
		
		checkHorizantal ();
		checkVertical ();
		checkDiagnol ();
		
		Collections.sort(winnersList);
		
		//System.out.println(winnersList);
		int i = 0;
		int totalUnique = 1;
		
		int totalSingle = 0;
		int totalDouble = 0;
		
		while (i < winnersList.size() - 1) {
			
			if (winnersList.get(i).equalsIgnoreCase(winnersList.get(i+1))) {
				winnersList.remove(i);
				continue;
			}
			i++;
		}
		//System.out.println(winnersList);
		i = 0;
		while (i < winnersList.size()) {
			
			 
				if (winnersList.get(i).length() == 2) {
					totalDouble++;
				}
				else {
					totalSingle++;
				}
			i++;
		}
		if (winnersList.size() == 0) {
			io.println(0);
			io.println(0);
		}
		else {
			io.println(totalSingle);
			io.println(totalDouble);
		}
		
		
		io.close();
		
		}
	
	public static void containsOne (List<Character> list) {
		
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) != list.get(i + 1)) {
				return ;
			}
		}
		
		sb.append(list.get(0));
		winnersList.add(sb.toString());
		//return true;
		
		
	}
	
	public static void containsTwo (List<Character> list) {
		StringBuffer sb = new StringBuffer();
		
		if ((list.get(0) == list.get(1)) && (list.get(0) == list.get(2))) {
			return ;
		}
		
		if ((list.get(0) != list.get(1)) && (list.get(0) != list.get(2)) && (list.get(2) != list.get(1)))  {
			return ;
		}
		
		if (list.get(0) == list.get(1)) {
			 if (list.get(0) > list.get(2)) {
				sb.append(list.get(2));
				sb.append(list.get(0));
				winnersList.add(sb.toString());
			 }
			 else {
				 	sb.append(list.get(0));
					sb.append(list.get(2));
					winnersList.add(sb.toString());
			 }
		}
		
		else if (list.get(1) == list.get(2)) {
			if (list.get(0) > list.get(2)) {
				sb.append(list.get(2));
				sb.append(list.get(0));
				winnersList.add(sb.toString());
			 }
			 else {
				 	sb.append(list.get(0));
					sb.append(list.get(2));
					winnersList.add(sb.toString());
			 }
		}
		else {
			if (list.get(0) > list.get(1)) {
				sb.append(list.get(1));
				sb.append(list.get(0));
				winnersList.add(sb.toString());
			 }
			 else {
				 	sb.append(list.get(0));
					sb.append(list.get(1));
					winnersList.add(sb.toString());
			 }
		}
		
	}
	
	public static void checkHorizantal () {
		
		//System.out.println(board.get(0) + " " + board.get(1) + " " + board.get(2));
		containsOne (board.get(0));
		containsOne (board.get(1));
		containsOne (board.get(2));
		//System.out.println(board.get(0) + " " + board.get(1) + " " + board.get(2));
		containsTwo (board.get(0));
		//System.out.println(board.get(0) + " " + board.get(1) + " " + board.get(2));
		containsTwo (board.get(1));
		//System.out.println(board.get(0) + " " + board.get(1) + " " + board.get(2));
		containsTwo (board.get(2));
		
		//System.out.println(board.get(0) + " " + board.get(1) + " " + board.get(2));
	}
	
	public static void checkVertical () {
		List<Character> vertical1 = new ArrayList<Character> ();
		List<Character> vertical2 = new ArrayList<Character> ();
		List<Character> vertical3 = new ArrayList<Character> ();
		
		for (int i = 0; i < 3; i++) {
			vertical1.add(board.get(i).get(0));
			vertical2.add(board.get(i).get(1));
			vertical3.add(board.get(i).get(2));
		}
		//System.out.println(vertical1 + " " + vertical2 + " " + vertical3);
		containsOne (vertical1);
		containsOne (vertical2);
		containsOne (vertical3);
		
		containsTwo (vertical1);
		containsTwo (vertical2);
		containsTwo (vertical3);
		
	}
	
	public static void checkDiagnol () {
		
		List<Character> diagonal1 = new ArrayList<Character> ();
		List<Character> diagonal2 = new ArrayList<Character> ();
		
		diagonal1.add(board.get(0).get(0));
		diagonal1.add(board.get(1).get(1));
		diagonal1.add(board.get(2).get(2));
		
		diagonal2.add(board.get(0).get(2));
		diagonal2.add(board.get(1).get(1));
		diagonal2.add(board.get(2).get(0));
		
		containsOne (diagonal1);
		containsOne (diagonal2);
		
		containsTwo (diagonal1);
		containsTwo (diagonal2);
	}

	
	
}
