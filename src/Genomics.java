import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Genomics {

	static Kattio io;
	static {
    	//System.out.println("in Try 1");
    	
            try {
				io = new Kattio("cownomics");
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
		int m = io.nextInt();
		
		ArrayList<String> spotty = new ArrayList<String> ();
		ArrayList<String> nonspotty = new ArrayList<String> ();
		
		for (int i = 0; i < n; i++) {
			spotty.add(io.next());
		}
		
		for (int i = 0; i < n; i++) {
			nonspotty.add(io.next());
		}
		int total = 0;
		
		for (int i = 0; i < m; i++) {
			for (int l = i+1; l < m; l++) {
				for (int u = l+1; u < m; u++){
						ArrayList<String> combs = new ArrayList<String> ();
						for (int j = 0; j < n; j++) {
							StringBuffer sb = new StringBuffer ();
							sb.append(spotty.get(j).charAt(i));
							sb.append(spotty.get(j).charAt(l));
							sb.append(spotty.get(j).charAt(u));
							combs.add(sb.toString());
						}
						
						int flag = 0;
						for (int j = 0; j < n; j++) {
							StringBuffer sb = new StringBuffer ();
							sb.append(nonspotty.get(j).charAt(i));
							sb.append(nonspotty.get(j).charAt(l));
							sb.append(nonspotty.get(j).charAt(u));
							String current = sb.toString();
							//combs.add(nonsb.toString());
							for (int s = 0; s < combs.size(); s++) {
								if (combs.get(s).equalsIgnoreCase(current)) {
									flag = 1;
									break;
								}
							}
							if (flag == 1) {
								break;
							}
						}
						
						if (flag == 0) {
							total++;
						}
						
					}
			}
		}
		
		io.println(total);
		io.close();
	}

}
