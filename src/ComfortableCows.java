import java.util.ArrayList;
import java.util.Scanner;

public class ComfortableCows {
	
	static class Cell {
		int x;
		int y;
	}
	static int[][] board = new int[1001][1001];
	static int[][] selfAdd = new int[1001][1001];
	static int count = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner (System.in);
		int  n = sc.nextInt();
		
		
		for (int i = 0; i < n; i++) {
			int inputx = sc.nextInt();
			int inputy = sc.nextInt();
			
			
			if (board[inputx][inputy] == 1) {
				count --;
				System.out.println(count);
				continue;
			}
			
			addToBoard (inputx, inputy);
			count--;
			System.out.println(count);
			
		}
	
		
	}
	public static void addToBoard (int inputx, int inputy) {
		if (board[inputx][inputy] == 0) {
			count++;
		}
		board[inputx][inputy] = 1;
		ArrayList<Cell> adjacent = getAdjacent (inputx, inputy);
		
		for (int j = 0; j < adjacent.size(); j++) {
			if (checkForCell (adjacent.get(j))) {
				Cell n = getRem(adjacent.get(j).x, adjacent.get(j).y);
				if (n != null) {
					addToBoard(n.x, n.y);
				}
				else {
					count++;
					return;
				}
			}
		}
	}
	public static ArrayList<Cell> getAdjacent (int x, int y) {
		ArrayList<Cell> adjacent = new ArrayList<Cell> ();
		
		int topx = x, topy = y+1;
		int botx = x, boty = y-1;
		int lefx = x-1, lefy = y;
		int rigx = x+1, rigy = y;
		
		if (inRange(topx, topy)) {
			Cell c = new Cell ();
			c.x = topx;
			c.y = topy;
			adjacent.add(c);
		}
		if (inRange(botx, boty)) {
			Cell c = new Cell ();
			c.x = botx;
			c.y = boty;
			adjacent.add(c);
		}
		if (inRange(lefx, lefy)) {
			Cell c = new Cell ();
			c.x = lefx;
			c.y = lefy;
			adjacent.add(c);
		}
		if (inRange(rigx, rigy)) {
			Cell c = new Cell ();
			c.x = rigx;
			c.y = rigy;
			adjacent.add(c);
		}
		Cell c = new Cell();
		c.x = x;
		c.y = y;
		adjacent.add(c);
		return adjacent;
	}
	
	public static boolean checkForCell (Cell c) {
		int x = c.x, y = c.y;
		int topx = x, topy = y+1;
		int botx = x, boty = y-1;
		int lefx = x-1, lefy = y;
		int rigx = x+1, rigy = y;
		int count = 0;
		if (inRange(topx, topy) && (board[topx][topy] == 1)) {
			count++;
		}
		if (inRange(botx, boty) && (board[botx][boty] == 1)) {
			count++;
		}
		if (inRange(lefx, lefy) && (board[lefx][lefy] == 1)) {
			count++;
		}
		if (inRange(rigx, rigy) && board[rigx][rigy] == 1) {
			count++;
		} 
		
		if (count == 3) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static Cell getRem (int x, int y) {
		Cell c = new Cell();
		int topx = x, topy = y+1;
		int botx = x, boty = y-1;
		int lefx = x-1, lefy = y;
		int rigx = x+1, rigy = y;
		int count = 0;
		if (inRange(topx, topy) && (board[topx][topy] == 0)) {
			c.x = topx;
			c.y = topy;
			return c;
		}
		if (inRange(botx, boty) && (board[botx][boty] == 0)) {
			c.x = botx;
			c.y = boty;
			return c;
		}
		if (inRange(lefx, lefy) && (board[lefx][lefy] == 0)) {
			c.x = lefx;
			c.y = lefy;
			return c;
		}
		if (inRange(rigx, rigy) && board[rigx][rigy] == 0) {
			c.x = rigx;
			c.y = rigy;
			return c;
		} 
		return null;
	}
	
	public static boolean inRange (int x, int y) {
		if ((x >= 0) && (x <= 1000) && (y >= 0) && (y <= 1000)) {
			return true;
		}
		return false;
	}
}
