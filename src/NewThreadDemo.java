
public class NewThreadDemo implements Runnable{
	
	Thread t;
	String name;
	Thread dependent;
	NewThreadDemo (Thread dependent, String name) throws InterruptedException{
		this.name = name;
		t = new Thread(this, this.name);
		this.dependent = dependent;
		
		System.out.println("Child Thread " + t);
	}
	
	NewThreadDemo (String name) {
		this.name = name;
		t = new Thread(this, this.name);
		
		System.out.println("Child Thread " + t);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (this.dependent != null ) {
			try {
				this.dependent.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			for (int l = 0; l < 5; l++) {
				System.out.println(this.name + l);
				Thread.sleep(100);
			}
		}
		catch (InterruptedException e) {
			System.out.println("Child Thread Interrupted ");
		}
		finally {
			
		}
		
		
	}
	
	
	
	
}
