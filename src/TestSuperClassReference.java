import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TestSuperClassReference {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestSuper t1 = new TestSub();
		ArrayList<Object> t = new ArrayList<Object> ();
		
		t.add(1);
		t.add("Hello");
		
		System.out.println(t.get(0).getClass());
		System.out.println(t.get(1).getClass());
		
		List<Integer> l = new ArrayList<Integer> ();
		ArrayList<Integer> l2 = new ArrayList<Integer> ();
		//l.add(0, null);
		//l = new LinkedList<Integer> ();
		//l.add(0, null);
		l2.trimToSize();
	
		ArrayList<Collection> g = new ArrayList<Collection> ();
		
		ArrayList<Object> g5 = new ArrayList<Object> ();
		g.add(l);
		g.add(l2);
		List<List<Integer>> g1 = new ArrayList<List<Integer>> ();
		g1.add(new ArrayList<Integer> ());
		g1.get(0).add(1);
		//g1.get(0).tr
		//g.get(0).
		Iterator<?> i = g.get(0).iterator();
		
		
		
		
		//g5.get(0).
		//ArrayList<Object> a = new ArrayList<Integer> ();
		
		
		
	}

	
	
	
	
}
