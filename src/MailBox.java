import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;


public class MailBox {
	
	static Kattio io;
	static {
    	//System.out.println("in Try 1");
    	
            try {
				io = new Kattio("whereami");
		        //io = new Kattio("problemname");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("in Try");
         
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = io.nextInt();
		String s = io.next();
		
		for (int k = 1; k <= n; k++) {
			HashSet<String> current = new HashSet<String> ();
			int flag = 0;
			for (int j = 0; j <= n-k; j++) {
				StringBuffer sb = new StringBuffer ();
				for (int l = j; l < j+k; l++) {
					sb.append(s.charAt(l));
				}
				if (current.contains(sb.toString())) {
					flag = 1;
					break;
				}
				current.add(sb.toString());
			}
			if (flag == 0) {
				io.println(k);
				io.close();
				return;
			}
		}
		
		io.close();
	}

}
